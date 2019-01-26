package ar.com.flow.sportslottery.domain

sealed trait TeamScore {
  val team: String
  val score: Int
}

case class HomeTeamScore(team: String, score: Int) extends TeamScore
case class VisitorTeamScore(team: String, score: Int) extends TeamScore
