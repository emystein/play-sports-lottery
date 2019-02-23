package ar.com.flow.sportslottery.domain

import java.time.LocalDate

case class RoundOf16Fixture(groupsRanking: GroupsRanking, schedules: List[LocalDate]) {
  val matchSchedulesInChronologicalOrder: List[MatchSchedule] = {
    val firstGroup = groupsRanking.groupRankingAtPosition(2)
    val nextGroup = groupsRanking.groupRankingAtPosition(3)
    List(MatchSchedule(firstGroup.teamInPosition(0), nextGroup.teamInPosition(1), schedules.head))
  }
}
