package ar.com.flow.sportslottery.domain

import java.util.{Calendar, Date}

class MatchEvent(val group: Set[String], val homeTeam: String, val visitorTeam: String, val date: Date) {
  require(homeTeam != visitorTeam, "Home and visitor should be different teams")
  require(group.contains(homeTeam), "Home should be in the group")
  require(group.contains(visitorTeam), "Visitor should be in the group")

  def this(group: Set[String], homeTeam: String, visitorTeam: String, year: Int, month: Int, day: Int) {
    this(group, homeTeam, visitorTeam, new Calendar.Builder().setDate(year, month - 1, day).build().getTime)
  }
}
