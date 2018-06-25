package ar.com.flow.sportslottery.domain

import java.util.Date

class MatchEvent(val homeTeam: String, val visitorTeam: String, date: Date) {
  require(homeTeam != visitorTeam, "Home and visitor should be different teams")
}
