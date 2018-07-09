package ar.com.flow.sportslottery.domain

class GroupsPhaseMetadata(val groups: Set[Group]) {
  val teamsByGroup = groups.map(g => g.name -> g.matchSchedules.flatMap(_.teams)).toMap
  val teams = teamsByGroup.values.flatten
  val scheduledMatches: Set[MatchSchedule] = groups.flatMap(_.matchSchedules)

  require(GroupsPhasePreconditions.onlyOneMatchPerDayForEachTeam(scheduledMatches), "A team can't play two matches the same day")
  require(GroupsPhasePreconditions.onlyOneGroupForEachTeam(teamsByGroup), "A team can't appear in more than one group")

  def getMatchSchedule(team1: String, team2: String): Option[MatchSchedule] = {
    scheduledMatches.find(_.teams == Set(team1, team2))
  }

  def matchHasBeenScheduled(matchSchedule: MatchSchedule): Boolean = {
    scheduledMatches.contains(matchSchedule)
  }
}
