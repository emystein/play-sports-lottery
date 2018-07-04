package ar.com.flow.sportslottery.domain

import java.util.Date

import com.google.common.collect.LinkedHashMultimap

import scala.collection.mutable
import scala.collection.mutable.MutableList

class GroupsPhase(val groups: Set[Group]) {
  val pendingMatches: mutable.Set[MatchSchedule] = mutable.Set.empty ++= groups.flatMap(_.matchSchedules)
  val matchResults: MutableList[MatchResult] = MutableList.empty

  val teamsByGroup = groups.map(g => g.name -> g.matchSchedules.map(s => Seq(s.homeTeam, s.visitorTeam)).flatten).toMap

  val teamRanks = groups.flatMap(_.matchSchedules).map(s => Seq(s.homeTeam -> new TeamRank(s.homeTeam),
                                                                s.visitorTeam -> new TeamRank(s.visitorTeam))).flatten.toMap

  require(groups.map(group => differentMatchDaysForTheSameTeam(group.matchSchedules)).forall(_ == true), "A team can't play two matches the same day")

  def differentMatchDaysForTheSameTeam(group: Set[MatchSchedule]): Boolean = {
    val teamsWithMoreThanOneMatchTheSameDay = group.toSeq.flatMap(m => Seq(TeamDate(m.homeTeam, m.date), TeamDate(m.visitorTeam, m.date)))
                                                         .groupBy(identity).mapValues(_.size).filter(_._2 > 1)
    teamsWithMoreThanOneMatchTheSameDay.isEmpty
  }

  def getPendingMatches() : Set[MatchSchedule] = {
    pendingMatches.toSet
  }

  def getMatchSchedule(team1: String, team2: String): Option[MatchSchedule] = {
    val lookupRivals = Set(team1, team2)

    groups.flatMap(_.matchSchedules).filter(_.teams == lookupRivals).headOption
  }

  def addMatchResult(matchSchedule: MatchSchedule, homeScore: Int, visitorScore: Int): MatchResult = {
    require(matchHasBeenScheduled(matchSchedule), "Can't add a result for a match that wasn't scheduled")

    val result = new MatchResult(matchSchedule, homeScore, visitorScore)
    matchSchedule.teams.map(team => teamRanks(team)).foreach(rank => rank.addMatchResult(result))

    matchResults += result
    pendingMatches -= matchSchedule

    result
  }

  def matchHasBeenScheduled(matchSchedule: MatchSchedule): Boolean = {
    groups.flatMap(_.matchSchedules).contains(matchSchedule)
  }

  def getGroupRanking(groupName: String): List[TeamRank] = {
    teamsByGroup.getOrElse(groupName, Seq.empty).map(teamRanks(_)).toList.sorted
  }
}

case class TeamDate(team: String, date: Date)