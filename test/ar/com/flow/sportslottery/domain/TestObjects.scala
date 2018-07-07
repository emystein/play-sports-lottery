package ar.com.flow.sportslottery.domain

import java.time.{LocalDate, MonthDay}
import java.util.Calendar

trait TestObjects {
  val day1 = LocalDate.of(2018, 6, 14)
  val day2 = LocalDate.of(2018, 6, 15)
  val day3 = LocalDate.of(2018, 6, 16)

  val notWorldCupGroup = Set("China", "Jakarta", "Kamchatka")
  val notWorldCupMatch = new MatchSchedule(notWorldCupGroup, "Jakarta", "China", 2019, 1, 1)

  val groupA = Set("Egypt", "Russia", "Saudi Arabia", "Uruguay")
  val russiaSaudiArabiaMatch = new MatchSchedule(groupA, "Russia", "Saudi Arabia", 2018, 6, 14)
  val egyptUruguayMatch = new MatchSchedule(groupA, "Egypt", "Uruguay", 2018, 6, 15)
  val uruguaySaudiArabiaMatch = new MatchSchedule(groupA, "Uruguay", "Saudi Arabia", 2018, 6, 18)
  val russiaEgyptMatch = new MatchSchedule(groupA, "Russia", "Egypt", 2018, 6, 19)
  val uruguayRussiaMatch = new MatchSchedule(groupA, "Uruguay", "Russia", 2018, 6, 25)
  val saudiArabiaEgyptMatch = new MatchSchedule(groupA, "Saudi Arabia", "Egypt", 2018, 6, 25)
  val groupAMatchSchedules = Group("A", Set(russiaSaudiArabiaMatch, egyptUruguayMatch, uruguaySaudiArabiaMatch, russiaEgyptMatch, uruguayRussiaMatch, saudiArabiaEgyptMatch))

  val groupB = Set("Iran", "Morocco", "Portugal", "Spain")
  val moroccoIranMatch = new MatchSchedule(groupB, "Morocco", "Iran", 2018, 6, 15)
  val portugalSpainMatch = new MatchSchedule(groupB, "Portugal", "Spain", 2018, 6, 15)
  val portugalMoroccoMatch = new MatchSchedule(groupB, "Portugal", "Morocco", 2018, 6, 20)
  val iranSpainMatch = new MatchSchedule(groupB, "Iran", "Spain", 2018, 6, 20)
  val spainMoroccoMatch = new MatchSchedule(groupB, "Spain", "Morocco", 2018, 6, 25)
  val iranPortugalMatch = new MatchSchedule(groupB, "Iran", "Portugal", 2018, 6, 25)
  val groupBMatchSchedules = Group("B", Set(moroccoIranMatch, portugalSpainMatch, portugalMoroccoMatch, iranSpainMatch, spainMoroccoMatch, iranPortugalMatch))

  val groupC = Set("Australia", "Denmark", "France", "Peru")
  val franceAustraliaMatch = new MatchSchedule(groupC, "France", "Australia", 2018, 6, 16)
  val peruDenmarkMatch = new MatchSchedule(groupC, "Peru", "Denmark", 2018, 6, 16)
  val denmarkAustraliaMatch = new MatchSchedule(groupC, "Denmark", "Australia", 2018, 6, 21)
  val francePeruMatch = new MatchSchedule(groupC, "France", "Peru", 2018, 6, 21)
  val australiaPeruMatch = new MatchSchedule(groupC, "Australia", "Peru", 2018, 6, 26)
  val denmarkFranceMatch = new MatchSchedule(groupC, "Denmark", "France", 2018, 6, 26)
  val groupCMatchSchedules = Group("C", Set(franceAustraliaMatch, peruDenmarkMatch, denmarkAustraliaMatch, francePeruMatch, australiaPeruMatch, denmarkFranceMatch))

  val groupD = Set("Argentina", "Iceland", "Croatia", "Nigeria")
  val argentinaIcelandMatch = new MatchSchedule(groupD, "Argentina", "Iceland", 2018, 6, 16)
  val croatiaNigeriaMatch = new MatchSchedule(groupD, "Croatia", "Nigeria", 2018, 6, 16)
  val argentinaCroatiaMatch = new MatchSchedule(groupD, "Argentina", "Croatia", 2018, 6, 21)
  val argentinaNigeriaMatch = new MatchSchedule(groupD, "Argentina", "Nigeria", 2018, 6, 26)
  val icelandCroatiaMatch = new MatchSchedule(groupD, "Iceland", "Croatia", 2018, 6, 26)
  val groupDMatchSchedules = Group("D", Set(croatiaNigeriaMatch, argentinaIcelandMatch, argentinaCroatiaMatch, argentinaNigeriaMatch))

  val croatiaNigeriaMatchResult = new MatchResult(croatiaNigeriaMatch, TeamScore("Croatia", 2), TeamScore("Nigeria", 0))
  val argentinaIcelandMatchResult = new MatchResult(argentinaIcelandMatch, TeamScore("Argentina", 1), TeamScore("Iceland", 1))
  val argentinaCroatiaMatchResult = new MatchResult(argentinaCroatiaMatch, TeamScore("Argentina", 0), TeamScore("Croatia", 3))
  val argentinaNigeriaMatchResult = new MatchResult(argentinaNigeriaMatch, TeamScore("Argentina", 2), TeamScore("Nigeria", 1))
  val icelandCroatiaMatchResult = new MatchResult(icelandCroatiaMatch, TeamScore("Iceland", 1), TeamScore("Croatia", 2))


  val argentinaRank = new TeamRank("Argentina")

  argentinaRank.addMatchResult(argentinaIcelandMatchResult)
  argentinaRank.addMatchResult(argentinaCroatiaMatchResult)
  argentinaRank.addMatchResult(argentinaNigeriaMatchResult)

  val croatiaRank = new TeamRank("Croatia")

  croatiaRank.addMatchResult(croatiaNigeriaMatchResult)
  croatiaRank.addMatchResult(argentinaCroatiaMatchResult)
  croatiaRank.addMatchResult(icelandCroatiaMatchResult)

  val groupE = Set("Brasil", "Costa Rica", "Serbia", "Switzerland")
  val costaRicaSerbiaMatch = new MatchSchedule(groupE, "Costa Rica", "Serbia", 2018, 6, 17)
  val brasilSwitzerlandMatch = new MatchSchedule(groupE, "Brasil", "Switzerland", 2018, 6, 17)
  val brasilCostaRicaMatch = new MatchSchedule(groupE, "Brasil", "Costa Rica", 2018, 6, 22)
  val serbiaSwitzerlandMatch = new MatchSchedule(groupE, "Serbia", "Switzerland", 2018, 6, 22)
  val serbiaBrasilMatch = new MatchSchedule(groupE, "Serbia", "Brasil", 2018, 6, 27)
  val switzerlandCostaRicaMatch = new MatchSchedule(groupE, "Switzerland", "Costa Rica", 2018, 6, 27)
  val groupEMatchSchedules = Group("E", Set(costaRicaSerbiaMatch, brasilSwitzerlandMatch, brasilCostaRicaMatch, serbiaSwitzerlandMatch, serbiaBrasilMatch, switzerlandCostaRicaMatch))

  val groupF = Set("Sweden", "Mexico", "Korea", "Germany")
  val germanyMexicoMatch = new MatchSchedule(groupF, "Germany", "Mexico", 2018, 6, 17)
  val swedenKoreaMatch = new MatchSchedule(groupF, "Sweden", "Korea", 2018, 6, 18)
  val koreaMexicoMatch = new MatchSchedule(groupF, "Korea", "Mexico", 2018, 6, 23)
  val germanySwedenMatch = new MatchSchedule(groupF, "Germany", "Sweden", 2018, 6, 23)
  val koreaGermanyMatch = new MatchSchedule(groupF, "Korea", "Germany", 2018, 6, 27)
  val mexicoSwedenMatch = new MatchSchedule(groupF, "Mexico", "Sweden", 2018, 6, 27)
  val groupFMatchSchedules = Group("F", Set(germanyMexicoMatch, swedenKoreaMatch, koreaMexicoMatch, germanySwedenMatch, koreaGermanyMatch, mexicoSwedenMatch))

}
