package ar.com.flow.sportslottery.domain

trait GroupedTeams {
  val groups: Set[Group]

  lazy val teamsByGroup: Map[String, Set[String]] = {
    (for {
      group <- groups
      matchSchedules = group.matchSchedules
    } yield {
      group.name -> matchSchedules.flatMap(_.teams)
    }).toMap
  }

  val teamGroup: Map[String, Group] = {
    (for {
      group <- groups
      team <- group.teams
    } yield {
      team -> group
    }).toMap
  }
}
