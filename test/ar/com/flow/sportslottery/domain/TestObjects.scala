package ar.com.flow.sportslottery.domain

import java.time.{LocalDate, MonthDay}
import java.util.Calendar

trait TestObjects {
  val day1 = LocalDate.of(2018, 6, 14)
  val day2 = LocalDate.of(2018, 6, 15)
  val day3 = LocalDate.of(2018, 6, 16)

  val notWorldCupGroup = Set("China", "Jakarta", "Kamchatka")
  val notWorldCupMatch = new MatchSchedule("Jakarta", "China", 2019, 1, 1)

  val groupATeams = Set("Egypt", "Russia", "Saudi Arabia", "Uruguay")
  val russiaSaudiArabiaMatch = new MatchSchedule("Russia", "Saudi Arabia", 2018, 6, 14)
  val egyptUruguayMatch = new MatchSchedule("Egypt", "Uruguay", 2018, 6, 15)
  val uruguaySaudiArabiaMatch = new MatchSchedule("Uruguay", "Saudi Arabia", 2018, 6, 18)
  val russiaEgyptMatch = new MatchSchedule("Russia", "Egypt", 2018, 6, 19)
  val uruguayRussiaMatch = new MatchSchedule("Uruguay", "Russia", 2018, 6, 25)
  val saudiArabiaEgyptMatch = new MatchSchedule("Saudi Arabia", "Egypt", 2018, 6, 25)
  val groupAMatchSchedules = Group("A", groupATeams, Set(russiaSaudiArabiaMatch, egyptUruguayMatch, uruguaySaudiArabiaMatch, russiaEgyptMatch, uruguayRussiaMatch, saudiArabiaEgyptMatch))

  val groupBTeams = Set("Iran", "Morocco", "Portugal", "Spain")
  val moroccoIranMatch = new MatchSchedule("Morocco", "Iran", 2018, 6, 15)
  val portugalSpainMatch = new MatchSchedule("Portugal", "Spain", 2018, 6, 15)
  val portugalMoroccoMatch = new MatchSchedule("Portugal", "Morocco", 2018, 6, 20)
  val iranSpainMatch = new MatchSchedule("Iran", "Spain", 2018, 6, 20)
  val spainMoroccoMatch = new MatchSchedule("Spain", "Morocco", 2018, 6, 25)
  val iranPortugalMatch = new MatchSchedule("Iran", "Portugal", 2018, 6, 25)
  val groupBMatchSchedules = Group("B", groupBTeams, Set(moroccoIranMatch, portugalSpainMatch, portugalMoroccoMatch, iranSpainMatch, spainMoroccoMatch, iranPortugalMatch))

  val groupCTeams = Set("Australia", "Denmark", "France", "Peru")
  val franceAustraliaMatch = new MatchSchedule("France", "Australia", 2018, 6, 16)
  val peruDenmarkMatch = new MatchSchedule("Peru", "Denmark", 2018, 6, 16)
  val denmarkAustraliaMatch = new MatchSchedule("Denmark", "Australia", 2018, 6, 21)
  val francePeruMatch = new MatchSchedule("France", "Peru", 2018, 6, 21)
  val australiaPeruMatch = new MatchSchedule("Australia", "Peru", 2018, 6, 26)
  val denmarkFranceMatch = new MatchSchedule("Denmark", "France", 2018, 6, 26)
  val groupCMatchSchedules = Group("C", groupCTeams, Set(franceAustraliaMatch, peruDenmarkMatch, denmarkAustraliaMatch, francePeruMatch, australiaPeruMatch, denmarkFranceMatch))

  val groupDTeams = Set("Argentina", "Iceland", "Croatia", "Nigeria")
  val argentinaIcelandMatch = new MatchSchedule("Argentina", "Iceland", 2018, 6, 16)
  val croatiaNigeriaMatch = new MatchSchedule("Croatia", "Nigeria", 2018, 6, 16)
  val argentinaCroatiaMatch = new MatchSchedule("Argentina", "Croatia", 2018, 6, 21)
  val nigeriaIcelandMatch = new MatchSchedule("Nigeria", "Iceland", 2018, 6, 22)
  val nigeriaArgentinaMatch = new MatchSchedule("Nigeria", "Argentina", 2018, 6, 26)
  val icelandCroatiaMatch = new MatchSchedule("Iceland", "Croatia", 2018, 6, 26)
  val groupDMatchSchedules = Group("D", groupDTeams, Set(argentinaIcelandMatch, croatiaNigeriaMatch, argentinaCroatiaMatch, nigeriaIcelandMatch, nigeriaArgentinaMatch, icelandCroatiaMatch))

  val croatiaNigeriaMatchResult = new MatchResult(croatiaNigeriaMatch, 2, 0)
  val argentinaIcelandMatchResult = new MatchResult(argentinaIcelandMatch, 1, 1)
  val argentinaCroatiaMatchResult = new MatchResult(argentinaCroatiaMatch, 0, 3)
  val nigeriaArgentinaMatchResult = new MatchResult(nigeriaArgentinaMatch, 1, 2)
  val icelandCroatiaMatchResult = new MatchResult(icelandCroatiaMatch, 1, 2)


  val argentinaRank = new TeamRank("Argentina")

  argentinaRank.addMatchResult(argentinaIcelandMatchResult)
  argentinaRank.addMatchResult(argentinaCroatiaMatchResult)
  argentinaRank.addMatchResult(nigeriaArgentinaMatchResult)

  val croatiaRank = new TeamRank("Croatia")

  croatiaRank.addMatchResult(croatiaNigeriaMatchResult)
  croatiaRank.addMatchResult(argentinaCroatiaMatchResult)
  croatiaRank.addMatchResult(icelandCroatiaMatchResult)

  val groupETeams = Set("Brazil", "Costa Rica", "Serbia", "Switzerland")
  val costaRicaSerbiaMatch = new MatchSchedule("Costa Rica", "Serbia", 2018, 6, 17)
  val BrazilSwitzerlandMatch = new MatchSchedule("Brazil", "Switzerland", 2018, 6, 17)
  val BrazilCostaRicaMatch = new MatchSchedule("Brazil", "Costa Rica", 2018, 6, 22)
  val serbiaSwitzerlandMatch = new MatchSchedule("Serbia", "Switzerland", 2018, 6, 22)
  val serbiaBrazilMatch = new MatchSchedule("Serbia", "Brazil", 2018, 6, 27)
  val switzerlandCostaRicaMatch = new MatchSchedule("Switzerland", "Costa Rica", 2018, 6, 27)
  val groupEMatchSchedules = Group("E", groupETeams, Set(costaRicaSerbiaMatch, BrazilSwitzerlandMatch, BrazilCostaRicaMatch, serbiaSwitzerlandMatch, serbiaBrazilMatch, switzerlandCostaRicaMatch))

  val groupFTeams = Set("Sweden", "Mexico", "Korea", "Germany")
  val germanyMexicoMatch = new MatchSchedule("Germany", "Mexico", 2018, 6, 17)
  val swedenKoreaMatch = new MatchSchedule("Sweden", "Korea", 2018, 6, 18)
  val koreaMexicoMatch = new MatchSchedule("Korea", "Mexico", 2018, 6, 23)
  val germanySwedenMatch = new MatchSchedule("Germany", "Sweden", 2018, 6, 23)
  val koreaGermanyMatch = new MatchSchedule("Korea", "Germany", 2018, 6, 27)
  val mexicoSwedenMatch = new MatchSchedule("Mexico", "Sweden", 2018, 6, 27)
  val groupFMatchSchedules = Group("F", groupFTeams, Set(germanyMexicoMatch, swedenKoreaMatch, koreaMexicoMatch, germanySwedenMatch, koreaGermanyMatch, mexicoSwedenMatch))

}
