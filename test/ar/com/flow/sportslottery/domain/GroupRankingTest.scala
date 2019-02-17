package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

class GroupRankingTest extends Specification with TestObjects {
  "GroupRanking" >> {
    "must order teams after adding match result" >> {
      val ranking = GroupRanking(groupD)

      ranking.addMatchResult(croatiaNigeriaMatch, 2, 0)
      ranking.addMatchResult(nigeriaArgentinaMatch, 1, 2)

      ranking.teamOrder must be equalTo List("Croatia", "Argentina", "Iceland", "Nigeria")
    }
  }
}
