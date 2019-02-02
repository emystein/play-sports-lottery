package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification
import org.specs2.specification.BeforeEach

import scala.collection.mutable

class GroupsPhaseTest extends Specification with BeforeEach with TestObjects {
  val allSchedules = Set(groupDMatchSchedules, groupAMatchSchedules)
  val groupsPhaseMetadata = new GroupsPhaseMetadata(allSchedules)
  var phase: GroupsPhase = null
  var argentinaVsNigeriaMatchSchedule: MatchSchedule = null

  def before = {
    phase = new GroupsPhase(groupsPhaseMetadata)
    argentinaVsNigeriaMatchSchedule = phase.metadata.getMatchSchedule("Argentina", "Nigeria").get
  }

  "Match results" >> {
    "Add a match result" >> {
      val matchResult = phase.addMatchResult(argentinaVsNigeriaMatchSchedule, 2, 1)

      phase.matchResults must contain(matchResult)
    }

    "Can't add a match result for a match that wasn't scheduled" >> {
      phase.addMatchResult(notWorldCupMatch, 2, 1) must
        throwA(new IllegalArgumentException("requirement failed: Can't add a result for a match that wasn't scheduled"))
    }
  }

  "Pending matches" >> {
    "When the phase begins all matches should be pending" >> {
      phase.pendingMatches must be equalTo allSchedules.flatMap(_.matchSchedules).to[mutable.Set]
    }

    "After playing a match it shouldn't appear as pending" >> {
      phase.addMatchResult(argentinaVsNigeriaMatchSchedule, 2, 1)

      phase.pendingMatches must not contain argentinaVsNigeriaMatchSchedule
    }
  }

  "Phase ranking" >> {
    "Add a match result must update both teams rank" >> {
      phase.addMatchResult(croatiaNigeriaMatch, 2, 0)

      val groupRanking = phase.groupsRanking.getGroupRanking("D")

      groupRanking.map(_.team) must be equalTo List("Croatia", "Argentina", "Iceland", "Nigeria")
    }
  }
}
