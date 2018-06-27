package ar.com.flow.sportslottery.domain

import java.util.Calendar

import org.specs2.mutable.Specification

class MatchEventTest extends Specification {
  "Create a Match Schedule" >> {
     val group = Set("Argentina", "Iceland", "Croatia", "Nigeria")

     val matchDate = new Calendar.Builder().setDate(2018, Calendar.JUNE, 25).build().getTime

    "Assign home and visitor" >> {
      val matchEvent = new MatchEvent(group, "Argentina", "Nigeria", matchDate)

      matchEvent.homeTeam must be equalTo "Argentina"
      matchEvent.visitorTeam must be equalTo "Nigeria"
    }

    "Assign date as separate year, month, day" >> {
      val matchEvent = new MatchEvent(group, "Argentina", "Nigeria", 2018, 6, 25)

      matchEvent.date must be equalTo matchDate
    }

    "Home should be in the group" >> {
      new MatchEvent(group, "Germany", "Iceland", matchDate) must
        throwA(new IllegalArgumentException("requirement failed: Home should be in the group"))
    }

    "Visitor should be in the group" >> {
      new MatchEvent(group, "Argentina", "Germany", matchDate) must
        throwA(new IllegalArgumentException("requirement failed: Visitor should be in the group"))
    }

    "Home and visitor should be different teams" >> {
      new MatchEvent(group, "Argentina", "Argentina", matchDate) must
        throwA(new IllegalArgumentException("requirement failed: Home and visitor should be different teams"))
    }

  }
}
