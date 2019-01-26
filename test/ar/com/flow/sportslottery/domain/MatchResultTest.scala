package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

class MatchResultTest extends Specification with TestObjects {
  "Match result" >> {
    "Register a win" >> {
      argentinaNigeriaMatchResult.winner must be equalTo Some("Argentina")
      argentinaNigeriaMatchResult.forTeam("Argentina") must be equalTo TeamMatchResult(HomeTeamScore("Argentina", 2), VisitorTeamScore("Nigeria", 1))
      argentinaNigeriaMatchResult.forTeam("Nigeria") must be equalTo TeamMatchResult(VisitorTeamScore("Nigeria", 1), HomeTeamScore("Argentina", 2))
    }

    "Register a deuce" >> {
      argentinaIcelandMatchResult.winner must be equalTo None
      argentinaIcelandMatchResult.forTeam("Argentina") must be equalTo TeamMatchResult(HomeTeamScore("Argentina", 1), VisitorTeamScore("Iceland", 1))
      argentinaIcelandMatchResult.forTeam("Iceland")  must be equalTo TeamMatchResult(VisitorTeamScore("Iceland", 1), HomeTeamScore("Argentina", 1))
    }
  }
}
