package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

class GroupsRankingTest extends Specification with TestObjects {
  "Group Ranking" >> {
    "Add a match result must update order of teams in ranking" >> {
      val ranking = GroupsRanking(groupsPhaseMetadata)

      ranking.addMatchResult(croatiaNigeriaMatch, 2, 0)
      // TODO investigate why without registering this result the ranking sometimes differs from the expected
      ranking.addMatchResult(nigeriaArgentinaMatch, 1, 2)

      ranking.getGroupRanking(groupD).teamOrder must be equalTo List("Croatia", "Argentina", "Iceland", "Nigeria")
    }
  }
}
