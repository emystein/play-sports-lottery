package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

class GroupsPhasePreconditionsTest extends Specification with TestObjects {
  "Verify all teams plays against each other within a group" >> {
    "When all matches are scheduled" >> {
      GroupsPhasePreconditions.allTeamsInAGroupPlayAgainstEachOther(groupATeams, groupA.matchSchedules) should beTrue
    }
    "When a match schedule is missing" >> {
      val matchSchedules = groupA.matchSchedules - russiaSaudiArabiaMatch
      GroupsPhasePreconditions.allTeamsInAGroupPlayAgainstEachOther(groupATeams, matchSchedules) should beFalse
    }
  }
}

