package ar.com.flow.sportslottery.domain

import java.util.Date

import scala.collection.mutable
import scala.collection.mutable.MutableList

class GroupsPhase(val groups: Set[Group]) {
  require(GroupsPhasePreconditions.everyTeamPlaysOnlyOneMatchTheSameDay(groups), "A team can't play two matches the same day")

  val metadata = new GroupsPhaseMetadata(groups)

  // mutable
  val pendingMatches: mutable.Set[MatchSchedule] = mutable.Set.empty ++= metadata.scheduledMatches
  val matchResults: MutableList[MatchResult] = MutableList.empty
  val teamRanks = metadata.teams.map(team => team -> new TeamRank(team)).toMap

  def getPendingMatches(): Set[MatchSchedule] = {
    pendingMatches.toSet
  }

  def getMatchSchedule(team1: String, team2: String): Option[MatchSchedule] = {
    val lookupRivals = Set(team1, team2)

    metadata.scheduledMatches.filter(_.teams == lookupRivals).headOption
  }

  def addMatchResult(matchSchedule: MatchSchedule, homeScore: Int, visitorScore: Int): MatchResult = {
    require(matchHasBeenScheduled(matchSchedule), "Can't add a result for a match that wasn't scheduled")

    pendingMatches -= matchSchedule

    new MatchResult(matchSchedule, homeScore, visitorScore)(matchResults, teamRanks)
  }

  def matchHasBeenScheduled(matchSchedule: MatchSchedule): Boolean = {
    metadata.scheduledMatches.contains(matchSchedule)
  }

  def getGroupRanking(groupName: String): List[TeamRank] = {
    metadata.teamsByGroup(groupName).map(teamRanks(_)).toList.sorted
  }
}

case class TeamDate(team: String, date: Date)