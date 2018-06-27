package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

class GroupsPhaseTest extends Specification with TestObjects {

  "Groups phase creation" >> {

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

  "Group phase matches" >> {
    val phase = GroupsPhase(Set(groupAMatchSchedules, groupBMatchSchedules))

    "Get a match event given teams in home and visitor order and date" >> {
      val matchEvent = phase.getMatchEvent("Argentina", "Iceland")

      matchEvent must be equalTo(Some(argentinaIcelandMatch))
    }

    "Get a match event given teams in visitor and home order and date" >> {
      val matchEvent = phase.getMatchEvent( "Iceland", "Argentina")

      matchEvent must be equalTo(Some(argentinaIcelandMatch))
    }

    "Looking up a match event between teams that don't play against each other throws an exception" >> {
      phase.getMatchEvent( "Germany", "Argentina") must be empty
    }

//
//    "Register a match result" >> {
//      val phase = GroupsPhase(Set(groupAMatchSchedules, groupBMatchSchedules))
//
//      val matchResult = phase.registerMatchResult(argentinaIcelandMatch, )
//    }
  }
}
