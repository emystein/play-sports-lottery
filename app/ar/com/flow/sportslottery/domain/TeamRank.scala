package ar.com.flow.sportslottery.domain

class TeamRank(val team: String) extends Ordered[TeamRank] {
  var matchesPlayed: Int = 0
  var goalsFavor: Int = 0
  var goalsAgainst: Int = 0
  var points: Int = 0

  def addMatchResult(matchResult: MatchResult) {
    require(matchResult.teams.contains(team), "Match result should correspond to team")

    matchesPlayed += 1

    val teamResult = matchResult.forTeam(team)

    goalsFavor += teamResult.goalsFavor
    goalsAgainst += teamResult.goalsAgainst
    points += teamResult.points
  }

  def compare(other: TeamRank): Int = {
    val goalDifference = goalsFavor - goalsAgainst
    val otherGoalDifference = other.goalsFavor - other.goalsAgainst
    ((points + goalDifference) compare (other.points + otherGoalDifference)) * -1
  }
}
