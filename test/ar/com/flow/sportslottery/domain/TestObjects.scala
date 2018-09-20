package ar.com.flow.sportslottery.domain

import java.time.{LocalDate, MonthDay}
import java.util.Calendar

trait TestObjects {
  val day1 = LocalDate.of(2018, 6, 14)
  val day2 = LocalDate.of(2018, 6, 15)
  val day3 = LocalDate.of(2018, 6, 16)

  val notWorldCupGroup = Set("China", "Jakarta", "Kamchatka")
  val notWorldCupMatch = new MatchSchedule("Jakarta", "China", 2019, 1, 1)

  val groupA = Set("Egypt", "Russia", "Saudi Arabia", "Uruguay")
  val russiaSaudiArabiaMatch = new MatchSchedule("Russia", "Saudi Arabia", 2018, 6, 14)
  val egyptUruguayMatch = new MatchSchedule("Egypt", "Uruguay", 2018, 6, 15)
  val uruguaySaudiArabiaMatch = new MatchSchedule("Uruguay", "Saudi Arabia", 2018, 6, 18)
  val russiaEgyptMatch = new MatchSchedule("Russia", "Egypt", 2018, 6, 19)
  val uruguayRussiaMatch = new MatchSchedule("Uruguay", "Russia", 2018, 6, 25)
  val saudiArabiaEgyptMatch = new MatchSchedule("Saudi Arabia", "Egypt", 2018, 6, 25)
  val groupAMatchSchedules = Group("A", Set(russiaSaudiArabiaMatch, egyptUruguayMatch, uruguaySaudiArabiaMatch, russiaEgyptMatch, uruguayRussiaMatch, saudiArabiaEgyptMatch))

  val groupB = Set("Iran", "Morocco", "Portugal", "Spain")
  val moroccoIranMatch = new MatchSchedule("Morocco", "Iran", 2018, 6, 15)
  val portugalSpainMatch = new MatchSchedule("Portugal", "Spain", 2018, 6, 15)
  val portugalMoroccoMatch = new MatchSchedule("Portugal", "Morocco", 2018, 6, 20)
  val iranSpainMatch = new MatchSchedule("Iran", "Spain", 2018, 6, 20)
  val spainMoroccoMatch = new MatchSchedule("Spain", "Morocco", 2018, 6, 25)
  val iranPortugalMatch = new MatchSchedule("Iran", "Portugal", 2018, 6, 25)
  val groupBMatchSchedules = Group("B", Set(moroccoIranMatch, portugalSpainMatch, portugalMoroccoMatch, iranSpainMatch, spainMoroccoMatch, iranPortugalMatch))

  val groupC = Set("Australia", "Denmark", "France", "Peru")
  val franceAustraliaMatch = new MatchSchedule("France", "Australia", 2018, 6, 16)
  val peruDenmarkMatch = new MatchSchedule("Peru", "Denmark", 2018, 6, 16)
  val denmarkAustraliaMatch = new MatchSchedule("Denmark", "Australia", 2018, 6, 21)
  val francePeruMatch = new MatchSchedule("France", "Peru", 2018, 6, 21)
  val australiaPeruMatch = new MatchSchedule("Australia", "Peru", 2018, 6, 26)
  val denmarkFranceMatch = new MatchSchedule("Denmark", "France", 2018, 6, 26)
  val groupCMatchSchedules = Group("C", Set(franceAustraliaMatch, peruDenmarkMatch, denmarkAustraliaMatch, francePeruMatch, australiaPeruMatch, denmarkFranceMatch))

  val groupD = Set("Argentina", "Iceland", "Croatia", "Nigeria")
  val argentinaIcelandMatch = new MatchSchedule("Argentina", "Iceland", 2018, 6, 16)
  val croatiaNigeriaMatch = new MatchSchedule("Croatia", "Nigeria", 2018, 6, 16)
  val argentinaCroatiaMatch = new MatchSchedule("Argentina", "Croatia", 2018, 6, 21)
  val argentinaNigeriaMatch = new MatchSchedule("Argentina", "Nigeria", 2018, 6, 26)
  val icelandCroatiaMatch = new MatchSchedule("Iceland", "Croatia", 2018, 6, 26)
  val groupDMatchSchedules = Group("D", Set(croatiaNigeriaMatch, argentinaIcelandMatch, argentinaCroatiaMatch, argentinaNigeriaMatch))

  val croatiaNigeriaMatchResult = new MatchResult(TeamScore("Croatia", 2), TeamScore("Nigeria", 0))()
  val argentinaIcelandMatchResult = new MatchResult(TeamScore("Argentina", 1), TeamScore("Iceland", 1))()
  val argentinaCroatiaMatchResult = new MatchResult(TeamScore("Argentina", 0), TeamScore("Croatia", 3))()
  val argentinaNigeriaMatchResult = new MatchResult(TeamScore("Argentina", 2), TeamScore("Nigeria", 1))()
  val icelandCroatiaMatchResult = new MatchResult(TeamScore("Iceland", 1), TeamScore("Croatia", 2))()


  val argentinaRank = new TeamRank("Argentina")

  argentinaRank.addMatchResult(argentinaIcelandMatchResult)
  argentinaRank.addMatchResult(argentinaCroatiaMatchResult)
  argentinaRank.addMatchResult(argentinaNigeriaMatchResult)

  val croatiaRank = new TeamRank("Croatia")

  croatiaRank.addMatchResult(croatiaNigeriaMatchResult)
  croatiaRank.addMatchResult(argentinaCroatiaMatchResult)
  croatiaRank.addMatchResult(icelandCroatiaMatchResult)

  val groupE = Set("Brazil", "Costa Rica", "Serbia", "Switzerland")
  val costaRicaSerbiaMatch = new MatchSchedule("Costa Rica", "Serbia", 2018, 6, 17)
  val BrazilSwitzerlandMatch = new MatchSchedule("Brazil", "Switzerland", 2018, 6, 17)
  val BrazilCostaRicaMatch = new MatchSchedule("Brazil", "Costa Rica", 2018, 6, 22)
  val serbiaSwitzerlandMatch = new MatchSchedule("Serbia", "Switzerland", 2018, 6, 22)
  val serbiaBrazilMatch = new MatchSchedule("Serbia", "Brazil", 2018, 6, 27)
  val switzerlandCostaRicaMatch = new MatchSchedule("Switzerland", "Costa Rica", 2018, 6, 27)
  val groupEMatchSchedules = Group("E", Set(costaRicaSerbiaMatch, BrazilSwitzerlandMatch, BrazilCostaRicaMatch, serbiaSwitzerlandMatch, serbiaBrazilMatch, switzerlandCostaRicaMatch))

  val groupF = Set("Sweden", "Mexico", "Korea", "Germany")
  val germanyMexicoMatch = new MatchSchedule("Germany", "Mexico", 2018, 6, 17)
  val swedenKoreaMatch = new MatchSchedule("Sweden", "Korea", 2018, 6, 18)
  val koreaMexicoMatch = new MatchSchedule("Korea", "Mexico", 2018, 6, 23)
  val germanySwedenMatch = new MatchSchedule("Germany", "Sweden", 2018, 6, 23)
  val koreaGermanyMatch = new MatchSchedule("Korea", "Germany", 2018, 6, 27)
  val mexicoSwedenMatch = new MatchSchedule("Mexico", "Sweden", 2018, 6, 27)
  val groupFMatchSchedules = Group("F", Set(germanyMexicoMatch, swedenKoreaMatch, koreaMexicoMatch, germanySwedenMatch, koreaGermanyMatch, mexicoSwedenMatch))

}
