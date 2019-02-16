package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

class GroupRankingTest extends Specification with TestObjects {
  "Group Ranking" >> {
    "Add a match result must update group ranking" >> {
      val ranking = GroupsRanking(groupsPhaseMetadata)

      ranking.addMatchResult(new MatchResult(croatiaNigeriaMatch, 2, 0))
      // TODO investigate why without registering this result the ranking sometimes differs from the expected
      ranking.addMatchResult(new MatchResult(nigeriaArgentinaMatch, 1, 2))

      val groupRanking = ranking.getGroupRanking("D")

      groupRanking.map(_.team) must be equalTo List("Croatia", "Argentina", "Iceland", "Nigeria")
    }
  }
}
