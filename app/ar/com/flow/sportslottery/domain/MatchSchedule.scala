package ar.com.flow.sportslottery.domain

import java.time.LocalDate

// TODO: make teams optional in order to support modeling matches don't defined yet (quarters, semis, final not played yet)
class MatchSchedule(val homeTeam: String, val visitorTeam: String, val date: LocalDate) {
  require(homeTeam != visitorTeam, "Home and visitor should be different teams")

  def this(homeTeam: String, visitorTeam: String, year: Int, month: Int, day: Int) {
    this(homeTeam, visitorTeam, LocalDate.of(year, month, day))
  }

  val teams = Set(homeTeam, visitorTeam)
}
