package ar.com.flow.sportslottery.domain

import scala.collection.mutable
import scala.collection.mutable.MutableList

class GroupsPhase(val metadata: GroupsPhaseMetadata) {
  val teamRanks = metadata.teams.map(team => team -> new TeamRank(team)).toMap

  // mutable
  val pendingMatches: mutable.Set[MatchSchedule] = metadata.scheduledMatches.to[mutable.Set]
  val matchResults: MutableList[MatchResult] = MutableList.empty

  def addMatchResult(matchSchedule: MatchSchedule, homeScore: Int, visitorScore: Int): MatchResult = {
    require(metadata.matchHasBeenScheduled(matchSchedule), "Can't add a result for a match that wasn't scheduled")

    pendingMatches -= matchSchedule

    new MatchResult(matchSchedule, homeScore, visitorScore)(matchResults, teamRanks)
  }

  def getGroupRanking(groupName: String): List[TeamRank] = {
    metadata.teamsByGroup(groupName).map(teamRanks(_)).toList.sorted
  }
}

