package ar.com.flow.sportslottery.domain

import java.time.LocalDate

trait KnockOutPhaseTestObjects {
  val firstRound1Result = new MatchResult(new TeamScore("Argentina", 3), new TeamScore("France", 4))
  val firstRound2Result = new MatchResult(new TeamScore("Uruguay", 2), new TeamScore("Portugal", 1))

  val quarterFinalsDate1 = LocalDate.of(2018, 7, 6)
  val quarterFinalsDate2 = LocalDate.of(2018, 7, 6)
  val quarterFinalsDate3 = LocalDate.of(2018, 7, 7)
  val quarterFinalsDate4 = LocalDate.of(2018, 7, 7)

  val semiFinalsDate1 = LocalDate.of(2018, 7, 10)
  val semiFinalsDate2 = LocalDate.of(2018, 7, 11)

  val finalDate = LocalDate.of(2018, 7, 15)

  val uruguayPortugalRoundOf16Match = new MatchSchedule("Uruguay", "Portugal", LocalDate.of(2018, 6, 30))
  val franceArgentinaRoundOf16Match = new MatchSchedule("France", "Argentina", LocalDate.of(2018, 6, 30))
  val brazilMexicoRoundOf16Match = new MatchSchedule("Brazil", "Mexico", LocalDate.of(2018, 7, 2))
  val belgiumJapanRoundOf16Match = new MatchSchedule("Belgium", "Japan", LocalDate.of(2018, 7, 2))
  val spainRussiaRoundOf16Match = new MatchSchedule("Spain", "Russia", LocalDate.of(2018, 7, 1))
  val croatiaDenmarkRoundOf16Match = new MatchSchedule("Croatia", "Denmark", LocalDate.of(2018, 7, 1))
  val swedenSwitzerlandRoundOf16Match = new MatchSchedule("Sweden", "Switzerland", LocalDate.of(2018, 7, 3))
  val colombiaEnglandRoundOf16Match = new MatchSchedule("Colombia", "England", LocalDate.of(2018, 7, 3))

  val roundOf16Schedules = Seq(uruguayPortugalRoundOf16Match, franceArgentinaRoundOf16Match, brazilMexicoRoundOf16Match, belgiumJapanRoundOf16Match,
    spainRussiaRoundOf16Match, croatiaDenmarkRoundOf16Match, swedenSwitzerlandRoundOf16Match, colombiaEnglandRoundOf16Match)

}
