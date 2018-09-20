package ar.com.flow.sportslottery.domain

import java.time.LocalDate

class KnockOutMatchFirstSchedule(phase: String, val homeTeam: String, val visitorTeam: String, val date: LocalDate) extends KnockOutMatchSchedule {

}
