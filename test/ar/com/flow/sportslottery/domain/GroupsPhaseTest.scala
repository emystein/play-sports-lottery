package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

class GroupsPhaseTest extends Specification with TestObjects {
  "Pending matches in groups phase" >> {
    "When the groups phase starts then all matches should be pending" >> {
      val phase = new GroupsPhase(groupsPhaseMetadata)

      phase.pendingMatches must containTheSameElementsAs(allGroups.flatMap(_.matchSchedules).toSeq)
    }

    "After playing a match then it should not appear as pending" >> {
      val phase = new GroupsPhase(groupsPhaseMetadata)

      phase.addMatchResult(nigeriaArgentinaMatch, 1, 2)

      phase.pendingMatches must not contain nigeriaArgentinaMatch
    }
  }

  "Match results" >> {
    "Add a match result" >> {
      val phase = new GroupsPhase(groupsPhaseMetadata)

      val matchResult = phase.addMatchResult(nigeriaArgentinaMatch, 1, 2)

      phase.matchResults must contain(matchResult)
    }

    "Can't add a match result for a match that wasn't scheduled" >> {
      val phase = new GroupsPhase(groupsPhaseMetadata)

      phase.addMatchResult(notWorldCupMatch, 2, 1) must
        throwA(new IllegalArgumentException("requirement failed: Can't add a result for a match that wasn't scheduled"))
    }
  }

  "Phase ranking" >> {
    "Add a match result must update both teams rank" >> {
      val phase = new GroupsPhase(groupsPhaseMetadata)

      phase.addMatchResult(croatiaNigeriaMatch, 2, 0)
      // TODO investigate why without registering this result the ranking sometimes differs from the expected
      phase.addMatchResult(nigeriaArgentinaMatch, 1, 2)

      val groupRanking = phase.groupsRanking.getGroupRanking("D")

      groupRanking.map(_.team) must be equalTo List("Croatia", "Argentina", "Iceland", "Nigeria")
    }
  }
}
