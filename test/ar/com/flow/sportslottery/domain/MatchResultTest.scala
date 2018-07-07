package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

class MatchResultTest extends Specification with TestObjects {
  "Match result" >> {
    "Get team result from a match result" >> {
      val argentinaMatchResult = argentinaIcelandMatchResult.forTeam("Argentina")

      argentinaMatchResult.team must be equalTo "Argentina"
    }

    "Register a win" >> {
      argentinaNigeriaMatchResult.winner must be equalTo Some("Argentina")
      argentinaNigeriaMatchResult.forTeam must be equalTo Map("Argentina" -> TeamMatchResult("Argentina", 2, 1), "Nigeria" -> TeamMatchResult("Nigeria", 1, 2))
    }

    "Register a deuce" >> {
      argentinaIcelandMatchResult.winner must be equalTo None
      argentinaIcelandMatchResult.forTeam must be equalTo Map("Argentina" -> TeamMatchResult("Argentina", 1, 1), "Iceland" -> TeamMatchResult("Iceland", 1, 1))
    }
  }
}
