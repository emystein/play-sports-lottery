package ar.com.flow.sportslottery.domain

import java.time.LocalDate

import org.specs2.mutable.Specification

class GroupsPhaseTest extends Specification with TestObjects {
  "Groups phase start" >> {
    "all matches should be pending" >> {
      val phase = new GroupsPhase(groupsPhaseMetadata)

      phase.pendingMatches must containTheSameElementsAs(allGroups.flatMap(_.matchSchedules).toSeq)
    }

    "After playing a match then it should removed from pending" >> {
      val phase = new GroupsPhase(groupsPhaseMetadata)

      phase.addMatchResult(nigeriaArgentinaMatch, 1, 2)

      phase.pendingMatches must not contain nigeriaArgentinaMatch
    }
  }

  "Match results in group phase" >> {
    "When adding a match result then it should appear in phase results" >> {
      val phase = new GroupsPhase(groupsPhaseMetadata)

      val matchResult = phase.addMatchResult(nigeriaArgentinaMatch, 1, 2)

      phase.matchResults must contain(matchResult)
    }

    "After playing a match then it should not appear as pending" >> {
      val phase = new GroupsPhase(groupsPhaseMetadata)

      phase.addMatchResult(nigeriaArgentinaMatch, 1, 2)

      phase.pendingMatches must not contain nigeriaArgentinaMatch
    }

    "Can't add a result for a match that wasn't scheduled" >> {
      val phase = new GroupsPhase(groupsPhaseMetadata)

      phase.addMatchResult(notWorldCupMatch, 2, 1) must
        throwA(PreconditionFailed("Can't add a result for a match that wasn't scheduled"))
    }

    "Can't add a result for a match which has a result already registered" >> {
      val phase = new GroupsPhase(groupsPhaseMetadata)
      phase.addMatchResult(nigeriaArgentinaMatch, 1, 2)
      phase.addMatchResult(nigeriaArgentinaMatch, 1, 2) must
        throwA(new IllegalArgumentException("requirement failed: Can't add a result for a match which has a result already registered"))
    }
  }

  "Phase ranking" >> {
    "Add a match result must update group ranking" >> {
      val phase = new GroupsPhase(groupsPhaseMetadata)

      phase.addMatchResult(croatiaNigeriaMatch, 2, 0)
      // TODO investigate why without registering this result the ranking sometimes differs from the expected
      phase.addMatchResult(nigeriaArgentinaMatch, 1, 2)

      val groupRanking = phase.groupsRanking.getGroupRanking(groupD)

      groupRanking.teamOrder must be equalTo List("Croatia", "Argentina", "Iceland", "Nigeria")
    }
  }


  "Finish phase" >> {
    "Add last pending match result should finish phase" >> {
      val matchSchedules = Set(MatchSchedule("Australia", "New Zealand", LocalDate.of(2018, 1, 1)))
      val group = Group("1", Set("Australia", "New Zealand"), matchSchedules)
      val phaseMetadata: GroupsPhaseMetadata = new GroupsPhaseMetadata(Set(group))
      val phase = new GroupsPhase(phaseMetadata)

      phase.addMatchResult(matchSchedules.head, 2, 1)

      phase.finished must be equalTo true
    }
  }
}
