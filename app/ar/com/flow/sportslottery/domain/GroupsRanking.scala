package ar.com.flow.sportslottery.domain

case class GroupsRanking(metadata: GroupsPhaseMetadata) {
  val teamRanks = metadata.teams.map(team => team -> new TeamRank(team)).toMap

  def add(result: MatchResult) = {
    result.matchSchedule.teams
      .map(team => teamRanks.getOrElse(team, new TeamRank(team)))
      .foreach(rank => rank.addMatchResult(result))
  }

  def getGroupRanking(groupName: String): List[TeamRank] = {
    metadata.teamsByGroup(groupName).map(teamRanks(_)).toList.sorted
  }
}
