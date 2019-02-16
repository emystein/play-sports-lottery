package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

class MatchResultTest extends Specification with TestObjects {
  "Match result" >> {
    "Teams" >> {
      nigeriaArgentinaMatchResult.teams must be equalTo Set("Nigeria", "Argentina")
    }
    "Register a win" >> {
      nigeriaArgentinaMatchResult.winner must be equalTo Some("Argentina")
      nigeriaArgentinaMatchResult.forTeam("Nigeria") must be equalTo TeamMatchResult(HomeTeamScore("Nigeria", 1), VisitorTeamScore("Argentina", 2))
      nigeriaArgentinaMatchResult.forTeam("Argentina") must be equalTo TeamMatchResult(VisitorTeamScore("Argentina", 2), HomeTeamScore("Nigeria", 1))
    }

    "Register a deuce" >> {
      argentinaIcelandMatchResult.winner must be equalTo None
      argentinaIcelandMatchResult.forTeam("Argentina") must be equalTo TeamMatchResult(HomeTeamScore("Argentina", 1), VisitorTeamScore("Iceland", 1))
      argentinaIcelandMatchResult.forTeam("Iceland")  must be equalTo TeamMatchResult(VisitorTeamScore("Iceland", 1), HomeTeamScore("Argentina", 1))
    }
  }
}
