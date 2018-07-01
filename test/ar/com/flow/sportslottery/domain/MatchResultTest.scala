package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

class MatchResultTest extends Specification with TestObjects {
  "Match result" >> {
    "Record a match result" >> {
      val matchResult = new MatchResult(argentinaNigeriaMatch, 2, 1)

      matchResult.winner must be equalTo Some("Argentina")
      matchResult.homeScore should be equalTo 2
      matchResult.visitorScore should be equalTo 1
      matchResult.teamResults must be equalTo Set(TeamMatchResult("Argentina", 3, 2, 1), TeamMatchResult("Nigeria", 0, 1, 2))
    }

    "Record a deuce" >> {
      val matchResult = new MatchResult(argentinaIcelandMatch, 1, 1)

      matchResult.winner must be equalTo None
      matchResult.teamResults must be equalTo Set(TeamMatchResult("Argentina", 1, 1, 1), TeamMatchResult("Iceland", 1, 1, 1))
    }
  }
}
