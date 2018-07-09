package ar.com.flow.sportslottery.domain

import java.time.LocalDate

object GroupsPhasePreconditions {
  def onlyOneMatchPerDayForEachTeam(matchSchedules: Set[MatchSchedule]): Boolean = {
    val teamsWithMoreThanOneMatchTheSameDay = matchSchedules.toSeq
      .flatMap(m => Seq(TeamDate(m.homeTeam, m.date), TeamDate(m.visitorTeam, m.date)))
      .groupBy(identity).mapValues(_.size).filter(_._2 > 1)
    teamsWithMoreThanOneMatchTheSameDay.isEmpty
  }

  def onlyOneGroupForEachTeam(teamsByGroup: Map[String, Set[String]]): Boolean = {
    val teamsPairs = for {
      teams1 <- teamsByGroup.values
      teams2 <- teamsByGroup.values
      if teams1 != teams2
    } yield (teams1, teams2)

    teamsPairs.forall(tp => tp._1.intersect(tp._2) == Set.empty)
  }
}

case class TeamDate(team: String, date: LocalDate)