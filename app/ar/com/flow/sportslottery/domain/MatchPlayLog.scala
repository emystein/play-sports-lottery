package ar.com.flow.sportslottery.domain

import scala.collection.mutable

case class MatchPlayLog(scheduledMatches: Set[MatchSchedule]) {
  val pendingMatches: mutable.Set[MatchSchedule] = scheduledMatches.to[mutable.Set]
  val matchResults: mutable.MutableList[MatchResult] = mutable.MutableList.empty

  def addResult(matchSchedule: MatchSchedule, homeScore: Int, visitorScore: Int) = {
    val result = new MatchResult(matchSchedule, homeScore, visitorScore)
    pendingMatches -= result.matchSchedule
    matchResults += result
    result
  }
}
