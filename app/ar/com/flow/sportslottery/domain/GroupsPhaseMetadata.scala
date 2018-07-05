package ar.com.flow.sportslottery.domain

class GroupsPhaseMetadata(val groups: Set[Group]) {
  val teamsByGroup = groups.map(g => g.name -> g.matchSchedules.flatMap(_.teams)).toMap
  val teams = teamsByGroup.values.flatten
  val scheduledMatches: Set[MatchSchedule] = groups.flatMap(_.matchSchedules)

}
