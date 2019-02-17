package ar.com.flow.sportslottery.domain

trait GroupedTeams {
  val groups: Set[Group]

  val teamGroup: Map[String, Group] = {
    (for {
      group <- groups
      team <- group.teams
    } yield {
      team -> group
    }).toMap
  }
}
