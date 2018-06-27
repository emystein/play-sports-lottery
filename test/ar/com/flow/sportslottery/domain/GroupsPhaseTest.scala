package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

class GroupsPhaseTest extends Specification with TestObjects {

  "Groups phase" >> {
    "Create a groups phase with two groups" >> {
      val phase = GroupsPhase(Set(groupAMatchSchedules, groupBMatchSchedules))

      phase.groups must contain(===(groupAMatchSchedules))
      phase.groups must contain(===(groupBMatchSchedules))
    }

    "A team can't play two matches the same day" >> {
      val argentinaIcelandMatch = new MatchEvent(groupA, "Argentina", "Iceland", day1)
      val argentinaCroatiaMatch = new MatchEvent(groupA, "Argentina", "Croatia", day1)

      val group = Set(argentinaIcelandMatch, argentinaCroatiaMatch)

      new GroupsPhase(Set(group)) should throwA(new IllegalArgumentException("requirement failed: A team can't play two matches the same day"))
    }

  }
}
