package ar.com.flow.sportslottery.domain

import java.time.LocalDate

import org.specs2.mutable.Specification

class KnockOutPhaseTest extends Specification with KnockOutPhaseTestObjects {
  "Knockout phase structure" >> {
    "16 starting teams plays in 16, quarter, semi and finals" >> {
      val knockoutPhase = new KnockoutPhaseStructure(
        Seq(new TeamsDefinedRound("Round of 16", roundOf16Schedules),
          new TeamsNotDefinedRound("Quarter Finals", Seq(quarterFinalsDate1, quarterFinalsDate2, quarterFinalsDate3, quarterFinalsDate4)),
          new TeamsNotDefinedRound("Semi Finals", Seq(semiFinalsDate1, semiFinalsDate2)),
          new TeamsNotDefinedRound("Finals", Seq(finalDate))))

      knockoutPhase.levels must have size 4
      knockoutPhase.levels(0).name must be equalTo "Round of 16"
      knockoutPhase.levels(1).name must be equalTo "Quarter Finals"
      knockoutPhase.levels(2).name must be equalTo "Semi Finals"
      knockoutPhase.levels(3).name must be equalTo "Finals"
    }
  }

  "Knockout phase schedule" >> {
    "Quarter finals match happens between winners of round of 16" >> {
      val firstRoundSchedule1 = new KnockOutMatchFirstSchedule("Round of 16", "Argentina", "France", LocalDate.of(2018, 6, 30))
      val firstRoundSchedule2 = new KnockOutMatchFirstSchedule("Round of 16", "Uruguay", "Portugal", LocalDate.of(2018, 6, 30))

      val quarterFinal1 = new MiddleKnockOutMatchSchedule("Quarter Finals", firstRoundSchedule1, firstRoundSchedule2, LocalDate.of(2018, 7, 15))

      val firstRoundSchedule3 = new KnockOutMatchFirstSchedule("Round of 16", "Brazil", "Mexico", LocalDate.of(2018, 7, 2))
      val firstRoundSchedule4 = new KnockOutMatchFirstSchedule("Round of 16", "Belgium", "Japan", LocalDate.of(2018, 7, 2))

      val quarterFinal2 = new MiddleKnockOutMatchSchedule("Quarter Finals", firstRoundSchedule3, firstRoundSchedule4, LocalDate.of(2018, 7, 6))

      val semiFinal1 = new MiddleKnockOutMatchSchedule("Semi Finals", quarterFinal1, quarterFinal2, LocalDate.of(2018, 7, 10))

      semiFinal1 must not be null
    }
  }
}
