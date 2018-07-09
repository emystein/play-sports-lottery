package ar.com.flow.sportslottery.domain

case class Group(name: String, matchSchedules: Set[MatchSchedule]) {
  matchSchedules.foreach(m =>
    require(m.homeTeam != m.visitorTeam, "Home and visitor should be different teams")
  )
}
