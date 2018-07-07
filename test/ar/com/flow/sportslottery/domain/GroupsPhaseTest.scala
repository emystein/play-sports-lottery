package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

import scala.collection.mutable

class GroupsPhaseTest extends Specification with TestObjects {
  val allSchedules = Set(groupDMatchSchedules, groupAMatchSchedules)
  val groupsPhaseMetadata = new GroupsPhaseMetadata(allSchedules)

  "Match results" >> {
    "Add a match result" >> {
      val phase = new GroupsPhase(groupsPhaseMetadata)

      val matchSchedule = phase.metadata.getMatchSchedule("Argentina", "Nigeria")

      val matchResult = phase.addMatchResult(matchSchedule.get, 2, 1)

      phase.matchResults must contain(matchResult)
      matchResult.homeScore must be equalTo 2
      matchResult.visitorScore must be equalTo 1
    }

    "Can't add a match result for a match that wasn't scheduled" >> {
      val phase = new GroupsPhase(groupsPhaseMetadata)

      phase.addMatchResult(notWorldCupMatch, 2, 1) must
        throwA(new IllegalArgumentException("requirement failed: Can't add a result for a match that wasn't scheduled"))
    }
  }

  "Pending matches" >> {
    "When the phase begins all matches should be pending" >> {
      val phase = new GroupsPhase(groupsPhaseMetadata)

      phase.pendingMatches must be equalTo(allSchedules.flatMap(_.matchSchedules).to[mutable.Set])
    }

    "After playing a match it shouldn't appear as pending" >> {
      val phase = new GroupsPhase(groupsPhaseMetadata)

      val maybeMatchSchedule = phase.metadata.getMatchSchedule("Argentina", "Nigeria")

      phase.addMatchResult(maybeMatchSchedule.get, 2, 1)

      phase.pendingMatches must not contain(maybeMatchSchedule.get)
    }
  }

  "Phase ranking" >> {
    "Add a match result must update both teams rank" >> {
      val phase = new GroupsPhase(groupsPhaseMetadata)

      phase.addMatchResult(croatiaNigeriaMatch, 2, 0)

      val groupRanking = phase.getGroupRanking("D")

      groupRanking.map(_.team) must be equalTo List("Croatia", "Argentina", "Iceland", "Nigeria")
    }
  }
}
