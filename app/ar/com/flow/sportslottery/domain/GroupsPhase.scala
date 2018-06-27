package ar.com.flow.sportslottery.domain

import java.util.Date

case class GroupsPhase(groups: Set[Set[MatchEvent]]) {

  require(groups.map(group => differentMatchDaysForTheSameTeam(group)).forall(_ == true), "A team can't play two matches the same day")

  def differentMatchDaysForTheSameTeam(group: Set[MatchEvent]): Boolean = {
    val teamsWithMoreThanOneMatchTheSameDay = group.toSeq.flatMap(m => Seq(TeamDate(m.homeTeam, m.date), TeamDate(m.visitorTeam, m.date)))
                                                         .groupBy(identity).mapValues(_.size).filter(_._2 > 1)
    teamsWithMoreThanOneMatchTheSameDay.isEmpty
  }

  def getMatchEvent(team1: String, team2: String): Option[MatchEvent] = {
    val lookupRivals = Set(team1, team2)

    groups.flatten.filter(matchEvent => Set(matchEvent.homeTeam, matchEvent.visitorTeam) == lookupRivals).headOption
  }
}

case class TeamDate(team: String, date: Date)