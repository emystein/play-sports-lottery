package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

class GroupPreconditionsTest extends Specification with TestObjects {
  "Verify all teams plays against each other" >> {
    "When all matches are scheduled" >> {
      GroupPreconditions.allTeamsPlayAgainstEachOther(groupATeams, groupAMatchSchedules.matchSchedules) should beTrue
    }
    "When a match is missing" >> {
      val matchSchedules = groupAMatchSchedules.matchSchedules - russiaSaudiArabiaMatch
      GroupPreconditions.allTeamsPlayAgainstEachOther(groupATeams, matchSchedules) should beFalse
    }
  }
}

class GroupTest extends Specification with TestObjects {
  "Verify all teams plays against each other" >> {
    "When a match is missing" >> {
      val matchSchedules = groupAMatchSchedules.matchSchedules - russiaSaudiArabiaMatch

      Group("A", groupATeams, matchSchedules) should
        throwA(new IllegalArgumentException("requirement failed: all teams must play against each other"))
    }
  }
}
