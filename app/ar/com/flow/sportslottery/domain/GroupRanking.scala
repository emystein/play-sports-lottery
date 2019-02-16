package ar.com.flow.sportslottery.domain

case class GroupRanking(teamRanks: List[TeamRank]) {
<<<<<<< HEAD
<<<<<<< HEAD
  var teamOrder = teamRanks.map(_.team)
=======
  val teamOrder = teamRanks.map(_.team)
>>>>>>> GroupRanking
=======
  var teamOrder = teamRanks.map(_.team)
>>>>>>> GroupsRanking constructs receiving groups intead of GroupsPhaseMetadata)
}
