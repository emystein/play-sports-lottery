package ar.com.flow.sportslottery.domain

case class Group(name: String, teams: Set[String] = Set.empty, matchSchedules: Set[MatchSchedule]) {
  require(GroupPreconditions.allTeamsPlayAgainstEachOther(teams, matchSchedules), "all teams must play against each other")
}

object GroupPreconditions {
  def allTeamsPlayAgainstEachOther(teams: Set[String], matchSchedules: Set[MatchSchedule]): Boolean = {
    val twoSidedTeamPairs = matchSchedules.flatMap(matchSchedule => Set((matchSchedule.homeTeam, matchSchedule.visitorTeam), (matchSchedule.visitorTeam, matchSchedule.homeTeam)))
    //    val matchesTeamPairs = matchSchedules.flatMap(matchSchedule => Set(matchSchedule.homeTeam, matchSchedule.visitorTeam))
    val tuples = teamCartesianPairs(teams)
    twoSidedTeamPairs == tuples
  }

  def teamCartesianPairs(teams: Set[String]): Set[(String, String)] = {
    for {
      team1 <- teams
      team2 <- teams
      if team1 != team2
    } yield (team1, team2)
  }
}
