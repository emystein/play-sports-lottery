package ar.com.flow.sportslottery.domain

class TeamRank(val team: String) extends Ordered[TeamRank] {
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
    (totals compare other.totals) * -1 // multiply by -1 to sort in descending order
  }
}
