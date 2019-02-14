package ar.com.flow.sportslottery.domain

import scala.collection.mutable
import scala.collection.mutable.MutableList

case class GroupsPhase(val metadata: GroupsPhaseMetadata) {
  val matchPlayLog: MatchPlayLog = MatchPlayLog(metadata.scheduledMatches)
  val pendingMatches: mutable.Set[MatchSchedule] = matchPlayLog.pendingMatches
  val matchResults: mutable.MutableList[MatchResult] = matchPlayLog.matchResults
  val groupsRanking: GroupsRanking = GroupsRanking(metadata.groups)
  def finished = pendingMatches.isEmpty

  def addMatchResult(matchSchedule: MatchSchedule, homeScore: Int, visitorScore: Int): MatchResult = {
    require(metadata.matchHasBeenScheduled(matchSchedule), "Can't add a result for a match that wasn't scheduled")
    require(pendingMatches.contains(matchSchedule), "Can't add a result for a match which has a result already registered")
    val result = matchPlayLog.addResult(matchSchedule, homeScore, visitorScore)
    groupsRanking.addMatchResult(result)
    result
  }
}
