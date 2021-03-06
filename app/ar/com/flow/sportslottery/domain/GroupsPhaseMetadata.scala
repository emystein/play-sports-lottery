package ar.com.flow.sportslottery.domain

import ar.com.flow.sportslottery.domain.GroupsPhasePreconditions._

case class GroupsPhaseMetadata(groups: Set[Group]) extends GroupedTeams {
  val scheduledMatches: Set[MatchSchedule] = groups.flatMap(_.matchSchedules)

  require(onlyOneMatchPerDayForEachTeam(scheduledMatches), "A team can't play two matches the same day")
  require(onlyOneGroupForEachTeam(teamsByGroup), "A team can't appear in more than one group")
  groups.foreach { group =>
    require(allTeamsInAGroupPlayAgainstEachOther(group.teams, group.matchSchedules), "all teams must play against each other")
  }

  def getMatchSchedule(team1: String, team2: String): Option[MatchSchedule] = {
    scheduledMatches.find(_.teams == Set(team1, team2))
  }

  def matchHasBeenScheduled(matchSchedule: MatchSchedule): Boolean = {
    scheduledMatches.contains(matchSchedule)
  }
}
