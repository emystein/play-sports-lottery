package ar.com.flow.sportslottery.domain

case class GroupRanking(group: Group) {
  val teamRanks: Map[String, TeamRank] = group.teams.map(team => team -> TeamRank(team)).toMap

  def addMatchResult(matchSchedule: MatchSchedule, homeScore: Int, visitorScore: Int): Unit = {
    addMatchResult(MatchResult(matchSchedule, homeScore, visitorScore))
  }

  def addMatchResult(matchResult: MatchResult) = {
    matchResult.teams
      .map(teamRanks)
      .foreach(rank => rank.addMatchResult(matchResult))
  }

  def teamOrder: List[String] = teamRanks.values.toList.sorted.map(_.team)

  def teamInPosition(position: Int): String = teamOrder(position)
}

