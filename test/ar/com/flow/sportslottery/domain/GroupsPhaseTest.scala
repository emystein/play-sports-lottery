package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

class GroupsPhaseTest extends Specification with TestObjects {

  "Phase creation" >> {
    "Create a groups phase with two groups" >> {
      val phase = new GroupsPhase(Set(groupAMatchSchedules, groupBMatchSchedules))
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

  "Match events" >> {
    val phase = new GroupsPhase(Set(groupAMatchSchedules, groupBMatchSchedules))

    "Get a match event given teams in home/visitor order" >> {
      val matchEvent = phase.getMatchEvent("Argentina", "Iceland")

      matchEvent must be equalTo (Some(argentinaIcelandMatch))
    }

    "Get a match event given teams in visitor/home order" >> {
      val matchEvent = phase.getMatchEvent("Iceland", "Argentina")

      matchEvent must be equalTo (Some(argentinaIcelandMatch))
    }

    "Get a match event between teams that don't belong to the same group must return Empty" >> {
      phase.getMatchEvent("Germany", "Argentina") must be empty
    }
  }

  "Match results" >> {
    "Register a match result" >> {
      val phase = new GroupsPhase(Set(groupAMatchSchedules, groupBMatchSchedules))

      val matchEvent = phase.getMatchEvent("Argentina", "Nigeria")

      val maybeMatchResult = phase.registerMatchResult(matchEvent, 2, 1)

      maybeMatchResult must be some
      val matchResult = maybeMatchResult.get
      phase.matchResults must contain(matchResult)
      matchResult.homeScore must be equalTo 2
      matchResult.visitorScore must be equalTo 1
    }

    "Register a match result for a non existing match event should register None" >> {
      val phase = new GroupsPhase(Set(groupAMatchSchedules, groupBMatchSchedules))

      val matchResult = phase.registerMatchResult(None, 0, 0)

      matchResult should be none
    }
  }
}
