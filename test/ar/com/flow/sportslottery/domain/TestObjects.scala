package ar.com.flow.sportslottery.domain

import java.util.Calendar

trait TestObjects {
  val day1 = new Calendar.Builder().setDate(2018, Calendar.JUNE, 14).build().getTime
  val day2 = new Calendar.Builder().setDate(2018, Calendar.JUNE, 15).build().getTime
  val day3 = new Calendar.Builder().setDate(2018, Calendar.JUNE, 16).build().getTime

  val groupA = Set("Argentina", "Iceland", "Croatia", "Nigeria")
  val argentinaIcelandMatch = new MatchEvent(groupA, "Argentina", "Iceland", 2018, 6, 16)
  val argentinaCroatiaMatch = new MatchEvent(groupA, "Argentina", "Croatia", 2018, 6, 21)
  val argentinaNigeriaMatch = new MatchEvent(groupA, "Argentina", "Nigeria", 2018, 6, 26)
  val groupAMatchSchedules = Set(argentinaIcelandMatch, argentinaCroatiaMatch, argentinaNigeriaMatch)

  val groupB = Set("Egypt", "Uruguay", "Morocco", "Iran")
  val egyptUruguayMatch = new MatchEvent(groupB, "Egypt", "Uruguay", 2018, 6, 15)
  val moroccoIranMatch = new MatchEvent(groupB, "Morocco", "Iran", 2018, 6, 15)
  val groupBMatchSchedules = Set(egyptUruguayMatch, moroccoIranMatch)

  val argentinaIcelandMatchResult = new MatchResult(argentinaIcelandMatch, 1, 1)
  val argentinaCroatiaMatchResult = new MatchResult(argentinaCroatiaMatch, 0, 3)
  val argentinaNigeriaMatchResult = new MatchResult(argentinaNigeriaMatch, 2, 1)
}
