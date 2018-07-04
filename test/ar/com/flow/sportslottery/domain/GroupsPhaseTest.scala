package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

import scala.collection.mutable

class GroupsPhaseTest extends Specification with TestObjects {
  val allSchedules = Set(groupDMatchSchedules, groupAMatchSchedules)

  "Phase creation" >> {
    "Create a groups phase with two groups" >> {
      val phase = new GroupsPhase(allSchedules)
      phase.groups must contain(===(groupDMatchSchedules))
      phase.groups must contain(===(groupAMatchSchedules))
    }

    "A team can't play two matches the same day" >> {
      val argentinaIcelandMatch = new MatchSchedule(groupD, "Argentina", "Iceland", day1)
      val argentinaCroatiaMatch = new MatchSchedule(groupD, "Argentina", "Croatia", day1)

      val group = Group("A", Set(argentinaIcelandMatch, argentinaCroatiaMatch))

      new GroupsPhase(Set(group)) should throwA(new IllegalArgumentException("requirement failed: A team can't play two matches the same day"))
    }
  }

  "Match schedules" >> {
    val phase = new GroupsPhase(allSchedules)

    "Get a match event given teams in home/visitor order" >> {
      val maybeMatchSchedule = phase.getMatchSchedule("Argentina", "Iceland")

      maybeMatchSchedule must be equalTo (Some(argentinaIcelandMatch))
    }

    "Get a match event given teams in visitor/home order" >> {
      val maybeMatchSchedule = phase.getMatchSchedule("Iceland", "Argentina")

      maybeMatchSchedule must be equalTo (Some(argentinaIcelandMatch))
    }

    "Get a match event between teams that don't belong to the same group must return Empty" >> {
      phase.getMatchSchedule("Germany", "Argentina") must be empty
    }
  }

  "Match results" >> {
    "Add a match result" >> {
      val phase = new GroupsPhase(allSchedules)

      val maybeMatchSchedule = phase.getMatchSchedule("Argentina", "Nigeria")

      val matchResult = phase.addMatchResult(maybeMatchSchedule.get, 2, 1)

      phase.matchResults must contain(matchResult)
      matchResult.homeScore must be equalTo 2
      matchResult.visitorScore must be equalTo 1
    }

    "Can't add a match result for a match that wasn't scheduled" >> {
      val phase = new GroupsPhase(allSchedules)

      phase.addMatchResult(notWorldCupMatch, 2, 1) must
        throwA(new IllegalArgumentException("requirement failed: Can't add a result for a match that wasn't scheduled"))
    }
  }

  "Pending matches" >> {
    "When the phase begins all matches should be pending" >> {
      val phase = new GroupsPhase(allSchedules)

      phase.getPendingMatches() must be equalTo(allSchedules.flatMap(_.matchSchedules))
    }

    "After playing a match it shouldn't appear as pending" >> {
      val phase = new GroupsPhase(allSchedules)

      val maybeMatchSchedule = phase.getMatchSchedule("Argentina", "Nigeria")

      phase.addMatchResult(maybeMatchSchedule.get, 2, 1)

      phase.getPendingMatches() must not contain(maybeMatchSchedule.get)
    }
  }

  "Phase ranking" >> {
    "Add a match result must update both teams rank" >> {
      val phase = new GroupsPhase(allSchedules)

      phase.addMatchResult(croatiaNigeriaMatch, 2, 0)

      val groupRanking = phase.getGroupRanking("D")

      groupRanking.map(_.team) must be equalTo List("Croatia", "Argentina", "Iceland", "Nigeria")
    }
  }
}
