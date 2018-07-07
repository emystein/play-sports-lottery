package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

class MatchResultTest extends Specification with TestObjects {
  "Match result" >> {
    "Get teams from a match result" >> {
      argentinaIcelandMatchResult.teams must be equalTo(Set("Argentina", "Iceland"))
    }

    "Get team result from a match result" >> {
      val argentinaMatchResult = argentinaIcelandMatchResult.getTeamResult("Argentina")

      argentinaMatchResult.team must be equalTo "Argentina"
    }

    "Can't get team result match for a team not part of the match result" >> {
      argentinaIcelandMatchResult.getTeamResult("Croatia") must
        throwA(new IllegalArgumentException("requirement failed: Team should part of match"))
    }

    "Register a win" >> {
      argentinaNigeriaMatchResult.winner must be equalTo Some("Argentina")
      argentinaNigeriaMatchResult.homeScore should be equalTo 2
      argentinaNigeriaMatchResult.visitorScore should be equalTo 1
      argentinaNigeriaMatchResult.teamResults must be equalTo Set(TeamMatchResult("Argentina", 2, 1), TeamMatchResult("Nigeria", 1, 2))
    }

    "Register a deuce" >> {
      argentinaIcelandMatchResult.winner must be equalTo None
      argentinaIcelandMatchResult.teamResults must be equalTo Set(TeamMatchResult("Argentina", 1, 1), TeamMatchResult("Iceland", 1, 1))
    }
  }
}
