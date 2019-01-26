package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

class MatchResultTest extends Specification with TestObjects {
  "Match result" >> {
    "Register a win" >> {
      argentinaNigeriaMatchResult.winner must be equalTo Some("Argentina")
      argentinaNigeriaMatchResult.forTeam("Argentina") must be equalTo TeamMatchResult("Argentina", 2, 1)
      argentinaNigeriaMatchResult.forTeam("Nigeria") must be equalTo TeamMatchResult("Nigeria", 1, 2)
    }

    "Register a deuce" >> {
      argentinaIcelandMatchResult.winner must be equalTo None
      argentinaIcelandMatchResult.forTeam("Argentina") must be equalTo TeamMatchResult("Argentina", 1, 1)
      argentinaIcelandMatchResult.forTeam("Iceland")  must be equalTo TeamMatchResult("Iceland", 1, 1)
    }
  }
}
