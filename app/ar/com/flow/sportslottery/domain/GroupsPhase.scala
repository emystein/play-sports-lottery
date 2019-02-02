package ar.com.flow.sportslottery.domain

import scala.collection.mutable
import scala.collection.mutable.MutableList

class GroupsPhase(val metadata: GroupsPhaseMetadata) {
  val groupsRanking = GroupsRanking(metadata)

  // mutable
  val pendingMatches: mutable.Set[MatchSchedule] = metadata.scheduledMatches.to[mutable.Set]
  val matchResults: MutableList[MatchResult] = MutableList.empty

  def addMatchResult(matchSchedule: MatchSchedule, homeScore: Int, visitorScore: Int): MatchResult = {
    require(metadata.matchHasBeenScheduled(matchSchedule), "Can't add a result for a match that wasn't scheduled")

    pendingMatches -= matchSchedule

    val result = new MatchResult(matchSchedule, homeScore, visitorScore)

    groupsRanking.add(result)

    matchResults += result

    result
  }
}

