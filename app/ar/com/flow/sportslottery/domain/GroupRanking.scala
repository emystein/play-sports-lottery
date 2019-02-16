package ar.com.flow.sportslottery.domain

case class GroupRanking(teamRanks: List[TeamRank]) {
<<<<<<< HEAD
  var teamOrder = teamRanks.map(_.team)
=======
  val teamOrder = teamRanks.map(_.team)
>>>>>>> GroupRanking
}
