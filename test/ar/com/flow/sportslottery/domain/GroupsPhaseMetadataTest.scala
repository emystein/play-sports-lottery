package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

class GroupsPhaseMetadataTest extends Specification with TestObjects {
  val allSchedules = Set(groupDMatchSchedules, groupAMatchSchedules)

  "Preconditions" >> {
    "A team can't appear in more than one group" >> {
      val argentinaIcelandMatch = new MatchSchedule(groupD, "Argentina", "Iceland", day1)
      val argentinaCroatiaMatch = new MatchSchedule(groupD, "Argentina", "Croatia", day2)

      val groupA = Group("A", Set(argentinaIcelandMatch))
      val groupB = Group("B", Set(argentinaCroatiaMatch))

      new GroupsPhaseMetadata(Set(groupA, groupB)) should throwA(new IllegalArgumentException("requirement failed: A team can't appear in more than one group"))
    }

    "A team can't play two matches the same day" >> {
      val argentinaIcelandMatch = new MatchSchedule(groupD, "Argentina", "Iceland", day1)
      val argentinaCroatiaMatch = new MatchSchedule(groupD, "Argentina", "Croatia", day1)

      val group = Group("A", Set(argentinaIcelandMatch, argentinaCroatiaMatch))

      new GroupsPhaseMetadata(Set(group)) should throwA(new IllegalArgumentException("requirement failed: A team can't play two matches the same day"))
    }
  }

  "Match schedules" >> {
    val phase = new GroupsPhaseMetadata(allSchedules)

    "Get a match event given teams in home/visitor order" >> {
      val matchSchedule = phase.getMatchSchedule("Argentina", "Iceland")

      matchSchedule must be equalTo (Some(argentinaIcelandMatch))
    }

    "Get a match event given teams in visitor/home order" >> {
      val matchSchedule = phase.getMatchSchedule("Iceland", "Argentina")

      matchSchedule must be equalTo (Some(argentinaIcelandMatch))
    }

    "Get a match event between teams that don't belong to the same group must return Empty" >> {
      phase.getMatchSchedule("Germany", "Argentina") must be empty
    }
  }

}
