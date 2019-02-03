package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification
import org.specs2.specification.BeforeEach

import scala.collection.mutable

class GroupsPhaseTest extends Specification with BeforeEach with TestObjects {
  var phase: GroupsPhase = null

  def before = {
    phase = new GroupsPhase(groupsPhaseMetadata)
  }

  "Pending matches" >> {
    "When the phase begins all matches should be pending" >> {
      phase.pendingMatches must be equalTo allGroups.flatMap(_.matchSchedules).to[mutable.Set]
    }

    "After playing a match it shouldn't appear as pending" >> {
      phase.addMatchResult(nigeriaArgentinaMatch, 1, 2)

      phase.pendingMatches must not contain nigeriaArgentinaMatch
    }
  }

  "Match results" >> {
    "Add a match result" >> {
      val matchResult = phase.addMatchResult(nigeriaArgentinaMatch, 1, 2)

      phase.matchResults must contain(matchResult)
    }

    "Can't add a match result for a match that wasn't scheduled" >> {
      phase.addMatchResult(notWorldCupMatch, 2, 1) must
        throwA(new IllegalArgumentException("requirement failed: Can't add a result for a match that wasn't scheduled"))
    }
  }

  "Phase ranking" >> {
    "Add a match result must update both teams rank" >> {
      phase.addMatchResult(croatiaNigeriaMatch, 2, 0)
      // TODO investigate why without registering this result the ranking sometimes differs from the expected
      phase.addMatchResult(nigeriaArgentinaMatch, 1, 2)

      val groupRanking = phase.groupsRanking.getGroupRanking("D")

      groupRanking.map(_.team) must be equalTo List("Croatia", "Argentina", "Iceland", "Nigeria")
    }
  }
}
