package ar.com.flow.sportslottery.domain

import java.time.LocalDate
import java.time.Month.JUNE

import org.specs2.mutable.Specification

class KnockoutPhaseFixtureOrganizationTest extends Specification with TestObjects {
  "Round of 16 fixture" >> {
    "First of group C must play with second of group B" >> {
      val groupsRanking = GroupsRanking(allGroups)

      allGroupsMatchResults.foreach(r => groupsRanking.addMatchResult(r))

      val roundOf16Schedules = List(LocalDate.of(2018, JUNE, 30))
      val roundOf16Fixture = RoundOf16Fixture(groupsRanking, roundOf16Schedules)

      roundOf16Fixture.matchSchedulesInChronologicalOrder.head must be equalTo franceArgentinaRoundOf16Match
    }
  }

}
