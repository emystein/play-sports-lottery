package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

class MatchResultTest extends Specification {
  "Match result" >> {
    "Record a match result" >> {
      val groupA = Set("Argentina", "Iceland", "Croatia", "Nigeria")

      val matchEvent = new MatchEvent(groupA, "Argentina", "Nigeria", 2018, 6, 26)

      val matchResult = MatchResult(matchEvent, 3, 0)

      matchResult.homeScore should be equalTo 3
      matchResult.visitorScore should be equalTo 0
    }
  }
}
