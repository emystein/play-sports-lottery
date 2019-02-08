package ar.com.flow.sportslottery.domain

case class GroupsRanking(groups: Set[Group]) {
  val teamRanks = groups.flatMap(_.teams).map(team => team -> new TeamRank(team)).toMap

  def addMatchResult(matchSchedule: MatchSchedule, homeScore: Int, visitorScore: Int): Unit = {
    addMatchResult(new MatchResult(matchSchedule, homeScore, visitorScore))
  }

  def addMatchResult(matchResult: MatchResult) = {
    matchResult.matchSchedule.teams
      .map(team => teamRanks.getOrElse(team, new TeamRank(team)))
      .foreach(rank => rank.addMatchResult(matchResult))
  }

  def getGroupRanking(group: Group): GroupRanking = {
    GroupRanking(group.teams.map(teamRanks).toList.sorted)
  }
}
