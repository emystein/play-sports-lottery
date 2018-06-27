package ar.com.flow.sportslottery.domain

import java.util.Calendar

import org.specs2.mutable.Specification

class GroupsPhaseTest extends Specification {

  "Groups phase" >> {
      val groupA = Set("Argentina", "Iceland", "Croatia", "Nigeria")

      val argentinaIcelandMatch = new MatchEvent(groupA, "Argentina", "Iceland", 2018, 6, 16)
      val argentinaCroatiaMatch = new MatchEvent(groupA, "Argentina", "Croatia", 2018, 6, 21)
      val groupAMatchSchedules = Set(argentinaIcelandMatch, argentinaCroatiaMatch)

      val groupB = Set("Egypt", "Uruguay", "Morocco", "Iran")
      val egyptUruguayMatch = new MatchEvent(groupB, "Egypt", "Uruguay", 2018, 6, 15)
      val moroccoIranMatch = new MatchEvent(groupB, "Morocco", "Iran", 2018, 6, 15)
      val groupBMatchSchedules = Set(egyptUruguayMatch, moroccoIranMatch)

    "Create a groups phase with two groups" >> {
      val phase = GroupsPhase(Set(groupAMatchSchedules, groupBMatchSchedules))

      phase.groups must contain(===(groupAMatchSchedules))
      phase.groups must contain(===(groupBMatchSchedules))
    }

    "A team can't play two matches the same day" >> {
      val date = new Calendar.Builder().setDate(2018, Calendar.JUNE, 16).build().getTime
      val argentinaIcelandMatch = new MatchEvent(groupA, "Argentina", "Iceland", date)
      val argentinaCroatiaMatch = new MatchEvent(groupA, "Argentina", "Croatia", date)

      val group = Set(argentinaIcelandMatch, argentinaCroatiaMatch)

      new GroupsPhase(Set(group)) should throwA(new IllegalArgumentException("requirement failed: A team can't play two matches the same day"))
    }

  }
}
