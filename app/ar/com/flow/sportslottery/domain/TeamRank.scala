package ar.com.flow.sportslottery.domain

case class TeamRank(team: String) extends Ordered[TeamRank] {
  private var totals: TeamMatchPoints = ZeroMatchPoints

  var matchesPlayed: Int = 0
  def goalsFavor: Int = totals.goalsFavor
  def goalsAgainst: Int = totals.goalsAgainst
  def goalDifference : Int = totals.goalDifference
  def points: Int = totals.points

  def addMatchResult(matchResult: MatchResult) {
    require(matchResult.matchSchedule.teams.contains(team), "Match result should correspond to team")
    matchesPlayed += 1
    totals = SumMatchPoints(totals, matchResult.forTeam(team))
  }

  def compare(other: TeamRank): Int = {
    ((totals.points + goalDifference) compare (other.totals.points + other.goalDifference)) * -1 // multiply by -1 to sort in descending order
  }
}
