package ar.com.flow.sportslottery.domain

case class GroupRanking(teamRanks: List[TeamRank]) {
  var teamOrder = teamRanks.map(_.team)
}
