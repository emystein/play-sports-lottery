package ar.com.flow.sportslottery.domain

import ar.com.flow.sportslottery.domain.GroupPreconditions.allTeamsPlayAgainstEachOther

case class Group(name: String, teams: Set[String] = Set.empty, matchSchedules: Set[MatchSchedule]) {
//  require(allTeamsPlayAgainstEachOther(teams, matchSchedules), "all teams must play against each other")
}

object GroupPreconditions {
  def allTeamsPlayAgainstEachOther(teams: Set[String], matchSchedules: Set[MatchSchedule]): Boolean = {
    val twoSidedTeamPairs = matchSchedules.flatMap(matchSchedule => cartesianPairs(matchSchedule.teams))
    twoSidedTeamPairs == cartesianPairs(teams)
  }

  private def cartesianPairs(teams: Set[String]): Set[(String, String)] = {
    for {
      team1 <- teams
      team2 <- teams
      if team1 != team2
    } yield (team1, team2)
  }
}
