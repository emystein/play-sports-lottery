package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

class TeamRankTest extends Specification with TestObjects {
  "Can't record result in rank for a different team" >> {
    val croatiaRank = new TeamRank("Crotia")
    val argentinaIcelandMatch = new MatchEvent(Set("Argentina", "Iceland", "Croatia", "Nigeria"), "Argentina", "Iceland", 2018, 6, 16)
    val argentinaIcelandMatchResult = new MatchResult(argentinaIcelandMatch, 1, 1)

    croatiaRank.recordMatchResult(argentinaIcelandMatchResult) must throwA(new IllegalArgumentException("requirement failed: Match result should correspond to team"))
  }

  "Add deuce result to rank" >> {
    val argentinaRank = new TeamRank("Argentina")

    argentinaRank.recordMatchResult(argentinaIcelandMatchResult)

    argentinaRank.points must be equalTo 1
  }

  "Add loose result to rank" >> {
    val argentinaRank = new TeamRank("Argentina")

    argentinaRank.recordMatchResult(argentinaCroatiaMatchResult)

    argentinaRank.points must be equalTo 0
  }

  "Add win result to rank" >> {
    val argentinaRank = new TeamRank("Argentina")

    argentinaRank.recordMatchResult(argentinaNigeriaMatchResult)

    argentinaRank.points must be equalTo 3
  }

  "Sum results" >> {
    val argentinaRank = new TeamRank("Argentina")

    argentinaRank.recordMatchResult(argentinaIcelandMatchResult)
    argentinaRank.recordMatchResult(argentinaCroatiaMatchResult)
    argentinaRank.recordMatchResult(argentinaNigeriaMatchResult)

    val argentinaPoints = argentinaIcelandMatchResult.homeResult().points +
                          argentinaCroatiaMatchResult.homeResult().points +
                          argentinaNigeriaMatchResult.homeResult().points

    argentinaRank.points must be equalTo argentinaPoints
  }
}
