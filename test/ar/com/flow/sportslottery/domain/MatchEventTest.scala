package ar.com.flow.sportslottery.domain

import java.util.Calendar

import org.specs2.mutable.Specification

class MatchEventTest extends Specification {
  "Create a Match Schedule" >> {
    val matchDate = new Calendar.Builder().setDate(2018, Calendar.JUNE, 25).build().getTime

    "Assign home and visitor" >> {
      val event = new MatchEvent("River", "Boca", matchDate)

      event.homeTeam must be equalTo "River"
      event.visitorTeam must be equalTo "Boca"
    }

    "Home and visitor should be different teams" >> {
      new MatchEvent("River", "River", matchDate) must
        throwA(new IllegalArgumentException("requirement failed: Home and visitor should be different teams"))
    }
  }
}
