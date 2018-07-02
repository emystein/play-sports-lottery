package ar.com.flow.sportslottery.domain

import java.util.Calendar

trait TestObjects {
  val day1 = new Calendar.Builder().setDate(2018, Calendar.JUNE, 14).build().getTime
  val day2 = new Calendar.Builder().setDate(2018, Calendar.JUNE, 15).build().getTime
  val day3 = new Calendar.Builder().setDate(2018, Calendar.JUNE, 16).build().getTime

  val notWorldCupGroup = Set("China", "Jakarta", "Kamchatka")
  val notWorldCupMatch = new MatchSchedule(notWorldCupGroup, "Jakarta", "China", 2019, 1, 1)

  val groupA = Set("Argentina", "Iceland", "Croatia", "Nigeria")
  val argentinaIcelandMatch = new MatchSchedule(groupA, "Argentina", "Iceland", 2018, 6, 16)
  val croatiaNigeriaMatch = new MatchSchedule(groupA, "Croatia", "Nigeria", 2018, 6, 16)
  val argentinaCroatiaMatch = new MatchSchedule(groupA, "Argentina", "Croatia", 2018, 6, 21)
  val argentinaNigeriaMatch = new MatchSchedule(groupA, "Argentina", "Nigeria", 2018, 6, 26)
  val icelandCroatiaMatch = new MatchSchedule(groupA, "Iceland", "Croatia", 2018, 6, 26)
  val groupAMatchSchedules = Group("A", Set(croatiaNigeriaMatch, argentinaIcelandMatch, argentinaCroatiaMatch, argentinaNigeriaMatch))

  val groupB = Set("Egypt", "Uruguay", "Morocco", "Iran")
  val egyptUruguayMatch = new MatchSchedule(groupB, "Egypt", "Uruguay", 2018, 6, 15)
  val moroccoIranMatch = new MatchSchedule(groupB, "Morocco", "Iran", 2018, 6, 15)
  val groupBMatchSchedules = Group("B", Set(egyptUruguayMatch, moroccoIranMatch))

  val croatiaNigeriaMatchResult = new MatchResult(croatiaNigeriaMatch, 2, 0)
  val argentinaIcelandMatchResult = new MatchResult(argentinaIcelandMatch, 1, 1)
  val argentinaCroatiaMatchResult = new MatchResult(argentinaCroatiaMatch, 0, 3)
  val argentinaNigeriaMatchResult = new MatchResult(argentinaNigeriaMatch, 2, 1)
  val icelandCroatiaMatchResult = new MatchResult(icelandCroatiaMatch, 1, 2)


  val argentinaRank = new TeamRank("Argentina")

  argentinaRank.addMatchResult(argentinaIcelandMatchResult)
  argentinaRank.addMatchResult(argentinaCroatiaMatchResult)
  argentinaRank.addMatchResult(argentinaNigeriaMatchResult)

  val croatiaRank = new TeamRank("Croatia")

  croatiaRank.addMatchResult(croatiaNigeriaMatchResult)
  croatiaRank.addMatchResult(argentinaCroatiaMatchResult)
  croatiaRank.addMatchResult(icelandCroatiaMatchResult)
}
