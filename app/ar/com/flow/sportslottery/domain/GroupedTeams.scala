package ar.com.flow.sportslottery.domain

trait GroupedTeams {
  val groups: Set[Group]

  val teams: Set[String] = groups.flatMap(_.teams)

  lazy val teamsByGroup: Map[String, Set[String]] = {
    groups.map(group => group.name -> group.teams).toMap
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
