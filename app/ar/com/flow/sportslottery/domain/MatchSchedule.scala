package ar.com.flow.sportslottery.domain

import java.time.LocalDate

class MatchSchedule(val group: Set[String], val homeTeam: String, val visitorTeam: String, val date: LocalDate) {
  require(group.contains(homeTeam), "Home should be in the group")
  require(group.contains(visitorTeam), "Visitor should be in the group")

  def this(group: Set[String], homeTeam: String, visitorTeam: String, year: Int, month: Int, day: Int) {
    this(group, homeTeam, visitorTeam, LocalDate.of(year, month, day))
  }

  val teams = Set(homeTeam, visitorTeam)
}
