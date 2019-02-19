package ar.com.flow.sportslottery.domain

import java.time.LocalDate

import org.specs2.mutable.Specification

class GroupsPhaseTest extends Specification with TestObjects {
  "Verify all teams plays against each other within a group" >> {
    "When all matches are scheduled" >> {
      GroupsPhasePreconditions.allTeamsInAGroupPlayAgainstEachOther(groupATeams, groupA.matchSchedules) should beTrue
    }
    "When a match schedule is missing" >> {
      val matchSchedules = groupA.matchSchedules - russiaSaudiArabiaMatch
      GroupsPhasePreconditions.allTeamsInAGroupPlayAgainstEachOther(groupATeams, matchSchedules) should beFalse
    }
  }

  "Groups phase start" >> {
    "all matches should be pending" >> {
      val phase = GroupsPhase(groupsPhaseMetadata)

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
      val phase = GroupsPhase(groupsPhaseMetadata)

      val matchResult = phase.addMatchResult(nigeriaArgentinaMatch, 1, 2)

      phase.matchResults must contain(matchResult)
    }

    "After playing a match then it should not appear as pending" >> {
      val phase = GroupsPhase(groupsPhaseMetadata)

      phase.addMatchResult(nigeriaArgentinaMatch, 1, 2)

      phase.pendingMatches must not contain nigeriaArgentinaMatch
    }

    "Can't add a result for a match that wasn't scheduled" >> {
      val phase = GroupsPhase(groupsPhaseMetadata)

      phase.addMatchResult(notWorldCupMatch, 2, 1) must
        throwA(PreconditionFailed("Can't add a result for a match that wasn't scheduled"))
    }

    "Can't add a result for a match which has a result already registered" >> {
      val phase = GroupsPhase(groupsPhaseMetadata)
      phase.addMatchResult(nigeriaArgentinaMatch, 1, 2)
      phase.addMatchResult(nigeriaArgentinaMatch, 1, 2) must
        throwA(new IllegalArgumentException("requirement failed: Can't add a result for a match which has a result already registered"))
    }
  }

  "Finish phase" >> {
    "Add last pending match result should finish phase" >> {
      val matchSchedules = Set(MatchSchedule("Australia", "New Zealand", LocalDate.of(2018, 1, 1)))
      val group = Group("1", Set("Australia", "New Zealand"), matchSchedules)
      val phaseMetadata: GroupsPhaseMetadata = GroupsPhaseMetadata(Set(group))
      val phase = GroupsPhase(phaseMetadata)

      phase.addMatchResult(matchSchedules.head, 2, 1)

      phase.finished must be equalTo true
    }
  }
}
