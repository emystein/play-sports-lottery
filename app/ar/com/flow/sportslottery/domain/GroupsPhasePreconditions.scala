package ar.com.flow.sportslottery.domain

import java.time.LocalDate

object GroupsPhasePreconditions {
  def onlyOneMatchPerDayForEachTeam(matchSchedules: Set[MatchSchedule]): Boolean = {
    val teamsWithMoreThanOneMatchTheSameDay = matchSchedules.toSeq
      .flatMap(m => Seq(TeamDate(m.homeTeam, m.date), TeamDate(m.visitorTeam, m.date)))
      .groupBy(identity).mapValues(_.size).filter(_._2 > 1)
    teamsWithMoreThanOneMatchTheSameDay.isEmpty
  }
}

case class TeamDate(team: String, date: LocalDate)