package ar.com.flow.sportslottery.domain

import scala.collection.mutable.MutableList

class MatchResult(val matchSchedule: MatchSchedule, val homeScore: Int, val visitorScore: Int)(implicit matchResults: MutableList[MatchResult] = MutableList.empty, teamRanks: Map[String, TeamRank] = Map.empty) {
  def teams = Set(matchSchedule.homeTeam, matchSchedule.visitorTeam)

  matchResults += this

  teams.map(team => teamRanks.getOrElse(team, new TeamRank(team)))
                      .foreach(rank => rank.addMatchResult(this))

  def teamResults: Set[TeamMatchResult] = {
    Set(resultFor(TeamScore(matchSchedule.homeTeam, homeScore), visitorScore),
        resultFor(TeamScore(matchSchedule.visitorTeam, visitorScore), homeScore))
  }

  def getTeamResult(team: String) = {
    require(teams.contains(team), "Team should part of match")

    teamResults.filter(_.team == team).head
  }

  def homeResult(): TeamMatchResult = {
    resultFor(matchSchedule.homeTeam)
  }

  def visitorResult(): TeamMatchResult = {
    resultFor(matchSchedule.visitorTeam)
  }

  def resultFor(team: String): TeamMatchResult = {
    teamResults.find(_.team == team).get
  }

  def resultFor(teamScore: TeamScore, oponentScore: Int): TeamMatchResult = {
    TeamMatchResult(teamScore.team, teamScore.score, oponentScore)
  }

  val winner = winnerOf(matchSchedule, homeScore, visitorScore)

  def winnerOf(matchSchedule: MatchSchedule, homeScore: Int, visitorScore: Int) = {
    if (homeScore == visitorScore) {
      None
    } else if (homeScore > visitorScore) {
      Some(matchSchedule.homeTeam)
    } else {
      Some(matchSchedule.visitorTeam)
    }
  }
}

case class TeamScore(team: String, score: Int)