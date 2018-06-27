package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

class MatchResultTest extends Specification with TestObjects {
  "Match result" >> {
    "Record a match result" >> {
      val matchResult = MatchResult(argentinaNigeriaMatch, 2, 1)

      matchResult.homeScore should be equalTo 2
      matchResult.visitorScore should be equalTo 1
    }
  }
}
