package ar.com.flow.sportslottery.domain

object GroupsPhasePreconditions {
  def everyTeamPlaysOnlyOneMatchTheSameDay(groups: Set[Group]): Boolean = {
    groups.map(group => differentMatchDaysForTheSameTeam(group.matchSchedules)).forall(_ == true)
  }

  def differentMatchDaysForTheSameTeam(group: Set[MatchSchedule]): Boolean = {
    val teamsWithMoreThanOneMatchTheSameDay = group.toSeq.flatMap(m => Seq(TeamDate(m.homeTeam, m.date), TeamDate(m.visitorTeam, m.date)))
      .groupBy(identity).mapValues(_.size).filter(_._2 > 1)
    teamsWithMoreThanOneMatchTheSameDay.isEmpty
  }
}
