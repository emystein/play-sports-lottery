package ar.com.flow.sportslottery.domain

import scala.collection.mutable.MutableList

class MatchResult(val matchSchedule: MatchSchedule, val homeGoals: Int, val visitorGoals: Int)(implicit matchResults: MutableList[MatchResult] = MutableList.empty, teamRanks: Map[String, TeamRank] = Map.empty) {
  def teams = Set(matchSchedule.homeTeam, matchSchedule.visitorTeam)

  val homeScore = TeamScore(matchSchedule.homeTeam, homeGoals)
  val visitorScore = TeamScore(matchSchedule.visitorTeam, visitorGoals)

  matchResults += this

  teams.map(team => teamRanks.getOrElse(team, new TeamRank(team)))
    .foreach(rank => rank.addMatchResult(this))

  def teamScores: Set[TeamScore] = Set(homeScore, visitorScore)

  def forTeam: Map[String, TeamMatchResult] = {
    val result = for {
      teamScore1 <- teamScores
      teamScore2 <- teamScores
      if teamScore1 != teamScore2
    } yield teamScore1.team -> resultFor(teamScore1, teamScore2)

    result.toMap
  }

  def resultFor(teamScore: TeamScore, oponentScore: TeamScore): TeamMatchResult = {
    TeamMatchResult(teamScore.team, teamScore.score, oponentScore.score)
  }

  val winner =
    if (homeScore.score == visitorScore.score) {
      None
    } else if (homeScore.score > visitorScore.score) {
      Some(matchSchedule.homeTeam)
    } else {
      Some(matchSchedule.visitorTeam)
    }
}

case class TeamScore(team: String, score: Int)