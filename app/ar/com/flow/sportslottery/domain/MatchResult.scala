package ar.com.flow.sportslottery.domain

class MatchResult(val matchSchedule: MatchSchedule, homePoints: Int, visitorPoints: Int)(implicit teamRanks: Map[String, TeamRank] = Map.empty) {
  val homeScore = HomeTeamScore(matchSchedule.homeTeam, homePoints)
  val visitorScore = HomeTeamScore(matchSchedule.visitorTeam, visitorPoints)
  val teamScores = Set(homeScore, visitorScore)

  matchSchedule.teams.map(team => teamRanks.getOrElse(team, new TeamRank(team))).foreach(rank => rank.addMatchResult(this))

  def forTeam: Map[String, TeamMatchResult] = {
    val result = for {
      teamScore1 <- teamScores
      teamScore2 <- teamScores
      if teamScore1 != teamScore2
    } yield teamScore1.team -> resultBasedOnScores(teamScore1, teamScore2)

    result.toMap
  }

  private def resultBasedOnScores(teamScore: TeamScore, oponentScore: TeamScore): TeamMatchResult = {
    TeamMatchResult(teamScore.team, teamScore.score, oponentScore.score)
  }

  // TODO: review potential duplicated code
  val winner = {
    if (homeScore.score == visitorScore.score) {
      None
    } else if (homeScore.score > visitorScore.score) {
      Some(homeScore.team)
    } else {
      Some(visitorScore.team)
    }
  }
}
