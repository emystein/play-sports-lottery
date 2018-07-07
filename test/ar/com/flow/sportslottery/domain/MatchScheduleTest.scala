package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

class MatchScheduleTest extends Specification with TestObjects {
  "Create a Match Schedule" >> {
    "Get teams" >> {
      argentinaIcelandMatch.teams must be equalTo Set("Argentina", "Iceland")
    }

    "Assign home and visitor" >> {
      argentinaIcelandMatch.homeTeam must be equalTo "Argentina"
      argentinaIcelandMatch.visitorTeam must be equalTo "Iceland"
    }

    "Assign date as separate year, month, day" >> {
      val matchEvent = new MatchSchedule(groupD, "Argentina", "Nigeria", 2018, 6, 16)

      matchEvent.date must be equalTo day3
    }

    "Home should be in the group" >> {
      new MatchSchedule(groupD, "Germany", "Iceland", day1) must
        throwA(new IllegalArgumentException("requirement failed: Home should be in the group"))
    }

    "Visitor should be in the group" >> {
      new MatchSchedule(groupD, "Argentina", "Germany", day1) must
        throwA(new IllegalArgumentException("requirement failed: Visitor should be in the group"))
    }

    "Home and visitor should be different teams" >> {
      new MatchSchedule(groupD, "Argentina", "Argentina", day1) must
        throwA(new IllegalArgumentException("requirement failed: Home and visitor should be different teams"))
    }
  }
}
