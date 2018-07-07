package ar.com.flow.sportslottery.domain


object MatchResultEnum extends Enumeration {
  type TeamMatchResult = Value
  val Lost, Deuce, Won = Value
}