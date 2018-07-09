package ar.com.flow.sportslottery.domain

import java.time.LocalDate

class MatchSchedule(val homeTeam: String, val visitorTeam: String, val date: LocalDate) {
  def this(homeTeam: String, visitorTeam: String, year: Int, month: Int, day: Int) {
    this(homeTeam, visitorTeam, LocalDate.of(year, month, day))
  }

  val teams = Set(homeTeam, visitorTeam)
}
