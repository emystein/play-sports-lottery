package ar.com.flow.sportslottery.domain

class TeamRank(team: String) {
  var matchPlayed: Int = 0
  var goalsFavor: Int = 0
  var goalsAgainst: Int = 0
  var points: Int = 0

  def recordMatchResult(matchResult: MatchResult) {
    require(matchResult.event.homeTeam == team || matchResult.event.visitorTeam == team, "Match result should correspond to team")

    val teamResult = matchResult.teamResults.filter(tr => tr.team == team).head

    points += teamResult.points
    goalsFavor += teamResult.goalsFavor
    goalsAgainst += teamResult.goalsAgainst
  }
}
