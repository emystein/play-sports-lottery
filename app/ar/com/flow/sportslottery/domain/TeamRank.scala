package ar.com.flow.sportslottery.domain

import scala.collection.mutable

class TeamRank(val team: String) extends Ordered[TeamRank] {
  var teamResults = mutable.MutableList[TeamMatchResult]()
  def matchesPlayed: Int = teamResults.size
  def goalsFavor: Int = teamResults.map(_.goalsFavor).sum
  def goalsAgainst: Int = teamResults.map(_.goalsAgainst).sum
  def points: Int = teamResults.map(_.points).sum

  def addMatchResult(matchResult: MatchResult) {
    require(matchResult.matchSchedule.teams.contains(team), "Match result should correspond to team")
    teamResults += matchResult.forTeam(team)
  }

  def compare(other: TeamRank): Int = {
    val goalDifference = goalsFavor - goalsAgainst
    val otherGoalDifference = other.goalsFavor - other.goalsAgainst
    ((points + goalDifference) compare (other.points + otherGoalDifference)) * -1
  }
}
