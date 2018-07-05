package ar.com.flow.sportslottery.domain

import scala.collection.mutable.MutableList

class MatchResult(val event: MatchSchedule, val homeScore: Int, val visitorScore: Int)(implicit matchResults: MutableList[MatchResult] = MutableList.empty, teamRanks: Map[String, TeamRank] = Map.empty) {
  def teams = Set(event.homeTeam, event.visitorTeam)

  matchResults += this

  teams.map(team => teamRanks.getOrElse(team, new TeamRank(team)))
                      .foreach(rank => rank.addMatchResult(this))

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
