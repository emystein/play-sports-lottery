package ar.com.flow.sportslottery.domain

class MatchResult(val matchSchedule: MatchSchedule, homePoints: Int, visitorPoints: Int)(implicit teamRanks: Map[String, TeamRank] = Map.empty) {
  val homeScore = HomeTeamScore(matchSchedule.homeTeam, homePoints)
  val visitorScore = VisitorTeamScore(matchSchedule.visitorTeam, visitorPoints)
  val teamScores = Set(homeScore, visitorScore)

  matchSchedule.teams.map(team => teamRanks.getOrElse(team, new TeamRank(team))).foreach(rank => rank.addMatchResult(this))

  def forTeam: Map[String, TeamMatchResult] = {
    val result = for {
      teamScore1 <- teamScores
      teamScore2 <- teamScores
      if teamScore1 != teamScore2
    } yield teamScore1.team -> TeamMatchResult(teamScore1, teamScore2)

    result.toMap
  }

  val winner = WinnerOf(homeScore, visitorScore)
}

case class TeamMatchResult(teamScore: TeamScore, opponentScore: TeamScore) {
  val goalsFavor: Int = teamScore.score
  val goalsAgainst: Int = opponentScore.score

  val points = WinnerOf(teamScore, opponentScore) match {
    case None => 1
    case Some(team) => if (team == teamScore.team) 3 else 0
  }
}

object WinnerOf {
  def apply(homeScore: TeamScore, visitorScore: TeamScore) = {
    if (homeScore.score == visitorScore.score) {
      None
    } else if (homeScore.score > visitorScore.score) {
      Some(homeScore.team)
    } else {
      Some(visitorScore.team)
    }
  }
}
