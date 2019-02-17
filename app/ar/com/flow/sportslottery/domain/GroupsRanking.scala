package ar.com.flow.sportslottery.domain

case class GroupsRanking(groups: Set[Group]) {
  val groupRanking = groups.map(group => group -> GroupRanking(group)).toMap

  def addMatchResult(matchSchedule: MatchSchedule, homeScore: Int, visitorScore: Int): Unit = {
    addMatchResult(new MatchResult(matchSchedule, homeScore, visitorScore))
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

  private val teamGroup: Map[String, Group] = {
    (for {
      group <- groups
      team <- group.teams
    } yield {
      team -> group
    }).toMap
  }
}
