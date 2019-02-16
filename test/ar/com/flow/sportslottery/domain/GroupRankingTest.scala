package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

class GroupRankingTest extends Specification with TestObjects {
  "GroupRanking" >> {
    "must order teams after adding match result" >> {
      val ranking = GroupsRanking(Set(groupD))

      ranking.addMatchResult(croatiaNigeriaMatch, 2, 0)
      ranking.addMatchResult(nigeriaArgentinaMatch, 1, 2)

      ranking.getGroupRanking(groupD).teamOrder must be equalTo List("Croatia", "Argentina", "Iceland", "Nigeria")
    }
  }
}
