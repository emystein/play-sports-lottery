package ar.com.flow.sportslottery.domain

class MatchResult(val homeScore: TeamScore, val visitorScore: TeamScore)(implicit teamRanks: Map[String, TeamRank] = Map.empty) {
  require(homeScore.team != visitorScore.team, "Home and visitor should be different teams")

  def this(matchSchedule: MatchSchedule, homeScore: Int, visitorScore: Int) {// TODO add (implicit teamRanks: Map[String, TeamRank] = Map.empty) {
    this(HomeTeamScore(matchSchedule.homeTeam, homeScore), VisitorTeamScore(matchSchedule.visitorTeam, visitorScore))() // TODO add (teamRanks)
  }

  val teams = Set(homeScore.team, visitorScore.team)

  teams.map(team => teamRanks.getOrElse(team, new TeamRank(team))).foreach(rank => rank.addMatchResult(this))

  def forTeam: Map[String, TeamMatchResult] = {
    val teamScores = Set(homeScore, visitorScore)

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
  val winner =
    if (homeScore.score == visitorScore.score) {
      None
    } else if (homeScore.score > visitorScore.score) {
      Some(homeScore.team)
    } else {
      Some(visitorScore.team)
    }
}
