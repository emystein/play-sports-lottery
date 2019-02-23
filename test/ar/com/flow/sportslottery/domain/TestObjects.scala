package ar.com.flow.sportslottery.domain

import java.time.Month.{JUNE, JULY}
import java.time.{LocalDate, MonthDay, YearMonth}
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
  val groupA = Group("A", groupATeams, Set(russiaSaudiArabiaMatch, egyptUruguayMatch, uruguaySaudiArabiaMatch, russiaEgyptMatch, uruguayRussiaMatch, saudiArabiaEgyptMatch))


  val russiaSaudiArabiaMatchResult = MatchResult(russiaSaudiArabiaMatch, 5, 0)
  val egyptUruguayMatchResult = MatchResult(egyptUruguayMatch, 0, 1)
  val russiaEgyptMatchResult = MatchResult(russiaEgyptMatch, 3, 1)
  val uruguaySaudiArabiaMatchResult = MatchResult(uruguaySaudiArabiaMatch, 1, 0)
  val uruguayRussiaMatchResult = MatchResult(uruguayRussiaMatch, 3, 0)
  val saudiArabiaEgyptResult = MatchResult(saudiArabiaEgyptMatch, 2, 1)

  val groupAMatchResults = Set(
    russiaSaudiArabiaMatchResult,
    egyptUruguayMatchResult,
    russiaEgyptMatchResult,
    uruguaySaudiArabiaMatchResult,
    uruguayRussiaMatchResult,
    saudiArabiaEgyptResult,
  )

  val groupBTeams = Set("Iran", "Morocco", "Portugal", "Spain")
  val moroccoIranMatch = new MatchSchedule("Morocco", "Iran", 2018, 6, 15)
  val portugalSpainMatch = new MatchSchedule("Portugal", "Spain", 2018, 6, 15)
  val portugalMoroccoMatch = new MatchSchedule("Portugal", "Morocco", 2018, 6, 20)
  val iranSpainMatch = new MatchSchedule("Iran", "Spain", 2018, 6, 20)
  val spainMoroccoMatch = new MatchSchedule("Spain", "Morocco", 2018, 6, 25)
  val iranPortugalMatch = new MatchSchedule("Iran", "Portugal", 2018, 6, 25)
  val groupB = Group("B", groupBTeams, Set(moroccoIranMatch, portugalSpainMatch, portugalMoroccoMatch, iranSpainMatch, spainMoroccoMatch, iranPortugalMatch))

  val moroccoIranMatchResult = MatchResult(moroccoIranMatch, 0, 1)
  val portugalSpainMatchResult = MatchResult(portugalSpainMatch, 3, 3)
  val portugalMoroccoMatchResult = MatchResult(portugalMoroccoMatch, 1, 0)
  val iranSpainMatchResult = MatchResult(iranSpainMatch, 0, 1)
  val spainMoroccoMatchResult = MatchResult(spainMoroccoMatch, 2, 2)
  val iranPortugalMatchResult = MatchResult(iranPortugalMatch, 1, 1)

  val groupBMatchResults = Set(
    moroccoIranMatchResult,
    portugalSpainMatchResult,
    portugalMoroccoMatchResult,
    iranSpainMatchResult,
    spainMoroccoMatchResult,
    iranPortugalMatchResult,
  )

  val groupCTeams = Set("Australia", "Denmark", "France", "Peru")
  val franceAustraliaMatch = new MatchSchedule("France", "Australia", 2018, 6, 16)
  val peruDenmarkMatch = new MatchSchedule("Peru", "Denmark", 2018, 6, 16)
  val denmarkAustraliaMatch = new MatchSchedule("Denmark", "Australia", 2018, 6, 21)
  val francePeruMatch = new MatchSchedule("France", "Peru", 2018, 6, 21)
  val australiaPeruMatch = new MatchSchedule("Australia", "Peru", 2018, 6, 26)
  val denmarkFranceMatch = new MatchSchedule("Denmark", "France", 2018, 6, 26)
  val groupC = Group("C", groupCTeams, Set(franceAustraliaMatch, peruDenmarkMatch, denmarkAustraliaMatch, francePeruMatch, australiaPeruMatch, denmarkFranceMatch))

  val franceAustraliaMatchResult = MatchResult(franceAustraliaMatch, 2, 1)
  val peruDenmarkMatchResult = MatchResult(peruDenmarkMatch, 0, 1)
  val denmarkAustraliaMatchResult = MatchResult(denmarkAustraliaMatch, 1, 1)
  val francePeruMatchResult = MatchResult(francePeruMatch, 1, 0)
  val australiaPeruMatchResult = MatchResult(australiaPeruMatch, 0, 2)
  val denmarkFranceMatchResult = MatchResult(denmarkFranceMatch, 0, 0)

  val groupCMatchResults = Set(
    franceAustraliaMatchResult,
    peruDenmarkMatchResult,
    denmarkAustraliaMatchResult,
    francePeruMatchResult,
    australiaPeruMatchResult,
    denmarkFranceMatchResult,
  )

  val groupDTeams = Set("Argentina", "Iceland", "Croatia", "Nigeria")
  val argentinaIcelandMatch = new MatchSchedule("Argentina", "Iceland", 2018, 6, 16)
  val croatiaNigeriaMatch = new MatchSchedule("Croatia", "Nigeria", 2018, 6, 16)
  val argentinaCroatiaMatch = new MatchSchedule("Argentina", "Croatia", 2018, 6, 21)
  val nigeriaIcelandMatch = new MatchSchedule("Nigeria", "Iceland", 2018, 6, 22)
  val nigeriaArgentinaMatch = new MatchSchedule("Nigeria", "Argentina", 2018, 6, 26)
  val icelandCroatiaMatch = new MatchSchedule("Iceland", "Croatia", 2018, 6, 26)
  val groupD = Group("D", groupDTeams, Set(argentinaIcelandMatch, croatiaNigeriaMatch, argentinaCroatiaMatch, nigeriaIcelandMatch, nigeriaArgentinaMatch, icelandCroatiaMatch))

  val croatiaNigeriaMatchResult = new MatchResult(croatiaNigeriaMatch, 2, 0)
  val argentinaIcelandMatchResult = new MatchResult(argentinaIcelandMatch, 1, 1)
  val argentinaCroatiaMatchResult = new MatchResult(argentinaCroatiaMatch, 0, 3)
  val nigeriaIcelandMatchResult = new MatchResult(nigeriaIcelandMatch, 2, 0)
  val nigeriaArgentinaMatchResult = new MatchResult(nigeriaArgentinaMatch, 1, 2)
  val icelandCroatiaMatchResult = new MatchResult(icelandCroatiaMatch, 1, 2)

  val groupDMatchResults = Set(
    argentinaIcelandMatchResult,
    croatiaNigeriaMatchResult,
    argentinaCroatiaMatchResult,
    nigeriaIcelandMatchResult,
    nigeriaArgentinaMatchResult,
    icelandCroatiaMatchResult,
  )

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
  val brazilCostaRicaMatch = new MatchSchedule("Brazil", "Costa Rica", 2018, 6, 22)
  val serbiaSwitzerlandMatch = new MatchSchedule("Serbia", "Switzerland", 2018, 6, 22)
  val serbiaBrazilMatch = new MatchSchedule("Serbia", "Brazil", 2018, 6, 27)
  val switzerlandCostaRicaMatch = new MatchSchedule("Switzerland", "Costa Rica", 2018, 6, 27)
  val groupE = Group("E", groupETeams, Set(costaRicaSerbiaMatch, BrazilSwitzerlandMatch, brazilCostaRicaMatch, serbiaSwitzerlandMatch, serbiaBrazilMatch, switzerlandCostaRicaMatch))

  val costaRicaSerbiaMatchResult = MatchResult(costaRicaSerbiaMatch, 0, 1)
  val brazilSwitzerlandMatchResult = MatchResult(serbiaBrazilMatch, 1, 1)
  val brazilCostaRicaMatchResult = MatchResult(brazilCostaRicaMatch, 2, 0)
  val serbiaSwitzerlandMatchResult = MatchResult(serbiaSwitzerlandMatch, 1, 2)
  val serbiaBrazilMatchResult = MatchResult(serbiaBrazilMatch, 0, 2)
  val switzerlandCostaRicaMatchResult = MatchResult(switzerlandCostaRicaMatch, 2, 2)

  val groupEMatchResults = Set(
    costaRicaSerbiaMatchResult,
    brazilSwitzerlandMatchResult,
    brazilCostaRicaMatchResult,
    serbiaSwitzerlandMatchResult,
    serbiaBrazilMatchResult,
    switzerlandCostaRicaMatchResult,
  )

  val groupFTeams = Set("Sweden", "Mexico", "Korea", "Germany")
  val germanyMexicoMatch = new MatchSchedule("Germany", "Mexico", 2018, 6, 17)
  val swedenKoreaMatch = new MatchSchedule("Sweden", "Korea", 2018, 6, 18)
  val koreaMexicoMatch = new MatchSchedule("Korea", "Mexico", 2018, 6, 23)
  val germanySwedenMatch = new MatchSchedule("Germany", "Sweden", 2018, 6, 23)
  val koreaGermanyMatch = new MatchSchedule("Korea", "Germany", 2018, 6, 27)
  val mexicoSwedenMatch = new MatchSchedule("Mexico", "Sweden", 2018, 6, 27)
  val groupF = Group("F", groupFTeams, Set(germanyMexicoMatch, swedenKoreaMatch, koreaMexicoMatch, germanySwedenMatch, koreaGermanyMatch, mexicoSwedenMatch))

  val germanyMexicoMatchResult = MatchResult(germanyMexicoMatch, 0, 1)
  val swedenKoreaMatchResult = MatchResult(swedenKoreaMatch, 1, 0)
  val koreaMexicoMatchResult = MatchResult(koreaMexicoMatch, 1, 2)
  val germanySwedenMatchResult = MatchResult(germanySwedenMatch, 2, 1)
  val koreaGermanyMatchResult = MatchResult(koreaGermanyMatch, 2, 0)
  val mexicoSwedenMatchResult = MatchResult(mexicoSwedenMatch, 0, 3)

  val groupFMatchResults = Set(
    germanyMexicoMatchResult,
    swedenKoreaMatchResult,
    koreaMexicoMatchResult,
    germanySwedenMatchResult,
    koreaGermanyMatchResult,
    mexicoSwedenMatchResult,
  )

  val belgiumPanamaMatch = new MatchSchedule("Belgium",  "Panama", LocalDate.of(2018, JUNE, 18))
  val tunisiaEnglandMatch = new MatchSchedule("Tunisia", "England", LocalDate.of(2018, JUNE, 18))
  val belgiumTunisiaMatch = new MatchSchedule("Belgium",  "Tunisia", LocalDate.of(2018, JUNE, 23))
  val englandPanamaMatch = new MatchSchedule("England", "Panama", LocalDate.of(2018, JUNE, 24))
  val panamaTunisiaMatch = new MatchSchedule("Panama", "Tunisia", LocalDate.of(2018, JUNE, 28))
  val englandBelgiumMatch = new MatchSchedule("England", "Belgium", LocalDate.of(2018, JUNE, 28))

  val groupGTeams = Set("Belgium", "Panama", "Tunisia", "England")
  val groupG = Group("G", groupGTeams, Set(belgiumPanamaMatch, tunisiaEnglandMatch, belgiumTunisiaMatch, englandPanamaMatch, panamaTunisiaMatch, englandBelgiumMatch))

  val belgiumPanamaMatchResult = MatchResult(belgiumPanamaMatch, 3, 0)
  val tunisiaEnglandMatchResult = MatchResult(tunisiaEnglandMatch, 1, 2)
  val belgiumTunisiaMatchResult = MatchResult(belgiumTunisiaMatch, 5, 2)
  val englandPanamaMatchResult = MatchResult(englandPanamaMatch, 6, 1)
  val panamaTunisiaMatchResult = MatchResult(panamaTunisiaMatch, 1, 2)
  val englandBelgiumMatchResult = MatchResult(englandBelgiumMatch, 0, 1)

  val groupGMatchResults = Set(
    belgiumPanamaMatchResult,
    tunisiaEnglandMatchResult,
    belgiumTunisiaMatchResult,
    englandPanamaMatchResult,
    panamaTunisiaMatchResult,
    englandBelgiumMatchResult
  )

  val colombiaJapanMatch = new MatchSchedule("Colombia", "Japan", LocalDate.of(2018, JUNE, 19))
  val polandSenegalMatch = new MatchSchedule("Poland", "Senegal", LocalDate.of(2018, JUNE, 19))
  val japanSenegalMatch = new MatchSchedule("Japan", "Senegal", LocalDate.of(2018, JUNE, 24))
  val polandColombiaMatch = new MatchSchedule("Poland", "Colombia", LocalDate.of(2018, JUNE, 24))
  val japanPolandMatch = new MatchSchedule("Japan", "Poland", LocalDate.of(2018, JUNE, 28))
  val senegalColombiaMatch = new MatchSchedule("Senegal", "Colombia", LocalDate.of(2018, JUNE, 28))

  val groupHTeams = Set("Colombia", "Japan", "Senegal", "Poland")
  val groupH = Group("H", groupHTeams, Set(colombiaJapanMatch, polandSenegalMatch, japanSenegalMatch, polandColombiaMatch, japanPolandMatch, senegalColombiaMatch))

  val colombiaJapanMatchResult = MatchResult(colombiaJapanMatch, 1, 2)
  val polandSenegalMatchResult = MatchResult(polandSenegalMatch, 1, 2)
  val japanSenegalMatchResult = MatchResult(japanSenegalMatch, 2, 2)
  val polandColombiaMatchResult = MatchResult(polandColombiaMatch, 0, 3)
  val japanPolandMatchResult = MatchResult(japanPolandMatch, 0, 1)
  val senegalColombiaMatchResult = MatchResult(senegalColombiaMatch, 0, 1)

  val groupHMatchResults = Set(
    colombiaJapanMatchResult,
    polandSenegalMatchResult,
    japanSenegalMatchResult,
    polandColombiaMatchResult,
    japanPolandMatchResult,
    senegalColombiaMatchResult,
  )

  // TODO rename to knockoutPhaseGroups
  val allGroups = Set(groupA, groupB, groupC, groupD, groupE, groupF, groupG, groupH)
  val groupsPhaseMetadata =  new GroupsPhaseMetadata(allGroups)
  val allGroupsMatchResults =
    groupAMatchResults ++
      groupBMatchResults ++
      groupCMatchResults ++
      groupDMatchResults ++
      groupEMatchResults ++
      groupFMatchResults ++
      groupGMatchResults ++
      groupHMatchResults

  val franceArgentinaRoundOf16Match = new MatchSchedule("France", "Argentina", LocalDate.of(2018, JUNE, 30))

  val franceBelgiumSemisMatch = MatchSchedule("France", "Belgium", LocalDate.of(2018, JULY, 10))
  val croatiaEnglandSemisMatch = MatchSchedule("France", "Belgium", LocalDate.of(2018, JULY, 11))
  // TODO move precondition of all teams playing against each other to collaborator object of Group
//  val semisGroup = Group("Semis", Set("France", "Belgium", "Croatia", "England"), Set(franceBelgiumSemisMatch, croatiaEnglandSemisMatch))

  val finalMatch = MatchSchedule("France", "Croatia", LocalDate.of(2018, JULY, 15))
//  val finalGroup = Group("Finals", Set("France", "Croatia"), Set(finalMatch))
}
