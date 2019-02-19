package ar.com.flow.sportslottery.domain

case class Group(name: String, teams: Set[String], matchSchedules: Set[MatchSchedule])

