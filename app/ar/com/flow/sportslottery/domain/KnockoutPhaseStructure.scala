package ar.com.flow.sportslottery.domain

class KnockoutPhaseStructure(val teams: Seq[Round]) {
  val levels = teams.map(r => new KnockoutLevel(r.name)).toVector
}

case class KnockoutLevel(name: String)
