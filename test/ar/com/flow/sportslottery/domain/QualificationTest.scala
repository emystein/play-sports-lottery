package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

object Qualify {
  def apply(ranking: List[TeamRank]) = {
//    val teams = ranking
    new Qualify(Group("a", Set(), Set()))
  }
}

case class Qualify(teams: Group)

class QualificationTest extends Specification with TestObjects {

//  "Qualify semis" >> {
//    "should choose first 2 of semis ranking" >> {
//      val ranking = GroupsRanking(GroupsPhaseMetadata(Set(semisGroup)))
//
//      val qualify = Qualify(ranking.getGroupRanking(semisGroup.name))
//
//      qualify.teams must be equalTo finalGroup
//    }
//  }

}
