package ar.com.flow.sportslottery.domain

class MatchResult(val event: MatchEvent, val homeScore: Int, val visitorScore: Int) {
  def teams = Set(event.homeTeam, event.visitorTeam)

  val winner = {
    if (homeScore == visitorScore) {
      None
    } else if (homeScore > visitorScore) {
      Some(event.homeTeam)
    } else {
      Some(event.visitorTeam)
    }
  }

  def teamResults: Set[TeamMatchResult] = {
    Set(homeResult(), visitorResult())
  }

  def getTeamResult(team: String) = {
    require(teams.contains(team), "Team should part of match")

    teamResults.filter(_.team == team).head
  }

  def homeResult(): TeamMatchResult = {
    resultFor(event.homeTeam, homeScore, visitorScore)
  }

  def visitorResult(): TeamMatchResult = {
    resultFor(event.visitorTeam, visitorScore, homeScore)
  }

  def resultFor(team: String, teamScore: Int, oponentScore: Int): TeamMatchResult = {
    if (winner == None) {
      TeamMatchResult(team, 1, teamScore, oponentScore)
    } else if (winner == Some(team)) {
      TeamMatchResult(team, 3, teamScore, oponentScore)
    } else {
      TeamMatchResult(team, 0, teamScore, oponentScore)
    }
  }
}
