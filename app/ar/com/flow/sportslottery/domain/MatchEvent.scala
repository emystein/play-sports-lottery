package ar.com.flow.sportslottery.domain

import java.util.{Calendar, Date}

class MatchEvent(val homeTeam: String, val visitorTeam: String, val date: Date) {
  require(homeTeam != visitorTeam, "Home and visitor should be different teams")

  def this(homeTeam: String, visitorTeam: String, year: Int, month: Int, day: Int) {
    this(homeTeam, visitorTeam, new Calendar.Builder().setDate(2018, month - 1, 25).build().getTime)
  }

}
