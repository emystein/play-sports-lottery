package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

class TeamMatchPointsTest extends Specification with TestObjects {
  val wonWithOneGoalFavor = TeamMatchResult(HomeTeamScore("Argentina", 2), VisitorTeamScore("Nigeria", 1))
  val wonWithTwoGoalsFavor = TeamMatchResult(HomeTeamScore("Argentina", 2), VisitorTeamScore("Nigeria", 0))
  val deuceResult = TeamMatchResult(HomeTeamScore("Argentina", 1), VisitorTeamScore("Iceland", 1))

  "TeamMatchPoints" >> {
    "Higher points must have higher order" >> {
      wonWithOneGoalFavor.compare(deuceResult) should be greaterThan 0
    }
    "Same points and higher goal difference must have higher order" >> {
      wonWithTwoGoalsFavor.compare(wonWithOneGoalFavor) should be greaterThan 0
    }
    "Same points and same goal difference must have same order" >> {
      wonWithOneGoalFavor.compare(wonWithOneGoalFavor) should be equalTo 0
    }
  }
}
