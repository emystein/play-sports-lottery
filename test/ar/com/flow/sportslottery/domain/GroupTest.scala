package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

class GroupTest extends Specification with TestObjects {
  "Home and visitor should be different teams" >> {
    Group("D", Set(new MatchSchedule("Argentina", "Argentina", day1))) must
      throwA(new IllegalArgumentException("requirement failed: Home and visitor should be different teams"))
  }
}
