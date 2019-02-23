package ar.com.flow.sportslottery.domain

case class GroupsRanking(groups: Set[Group]) extends GroupedTeams {
  val groupRanking = groups.map(group => group -> GroupRanking(group)).toMap
  val groupList = groups.toList.sortBy(g => g.name)

  def addMatchResult(matchSchedule: MatchSchedule, homeScore: Int, visitorScore: Int): Unit = {
    addMatchResult(MatchResult(matchSchedule, homeScore, visitorScore))
  }

  def addMatchResult(matchResult: MatchResult) = {
    matchResult.teams
      .map(teamGroup)
      .map(getGroupRanking)
      .foreach(_.addMatchResult(matchResult))
  }

  def getGroupRanking(group: Group): GroupRanking = {
    groupRanking(group)
  }

  def groupRankingAtPosition(i: Int) = {
    groupRanking(groupList(i))
  }
}
