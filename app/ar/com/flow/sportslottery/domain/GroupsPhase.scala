package ar.com.flow.sportslottery.domain

import java.util.Date

import scala.collection.mutable
import scala.collection.mutable.MutableList

class GroupsPhase(val metadata: GroupsPhaseMetadata) {
  val teamRanks = metadata.teams.map(team => team -> new TeamRank(team)).toMap

  // mutable
  val pendingMatches: mutable.Set[MatchSchedule] = mutable.Set.empty ++= metadata.scheduledMatches
  val matchResults: MutableList[MatchResult] = MutableList.empty

  def getPendingMatches(): Set[MatchSchedule] = {
    pendingMatches.toSet
  }

  def addMatchResult(matchSchedule: MatchSchedule, homeScore: Int, visitorScore: Int): MatchResult = {
    require(metadata.matchHasBeenScheduled(matchSchedule), "Can't add a result for a match that wasn't scheduled")

    pendingMatches -= matchSchedule

    new MatchResult(matchSchedule, homeScore, visitorScore)(matchResults, teamRanks)
  }

  def getGroupRanking(groupName: String): List[TeamRank] = {
    metadata.teamsByGroup(groupName).map(teamRanks(_)).toList.sorted
  }
}

case class TeamDate(team: String, date: Date)