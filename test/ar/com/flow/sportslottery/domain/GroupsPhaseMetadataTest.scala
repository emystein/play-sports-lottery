package ar.com.flow.sportslottery.domain

import org.specs2.mutable.Specification

class GroupsPhaseMetadataTest extends Specification with TestObjects {
  "GroupsPhase preconditions" >> {
    "A team can't appear in more than one group" >> {
      val groupA1 = Group("A", argentinaIcelandMatch.teams, Set(argentinaIcelandMatch))
      val groupB1 = Group("B", argentinaCroatiaMatch.teams, Set(argentinaCroatiaMatch))

      GroupsPhaseMetadata(Set(groupA1, groupB1)) should throwA(PreconditionFailed("A team can't appear in more than one group"))
    }

    "A team can't play two matches the same day" >> {
      val argentinaCroatiaMatch = MatchSchedule("Argentina", "Croatia", argentinaIcelandMatch.date)

      val group = Group("A", Set("Argentina", "Iceland", "Croatia"), Set(argentinaIcelandMatch, argentinaCroatiaMatch, icelandCroatiaMatch))

      GroupsPhaseMetadata(Set(group)) should throwA(PreconditionFailed("A team can't play two matches the same day"))
    }

    "All teams in a group plays against each other" >> {
      "When a match is missing" >> {
        val matchSchedules = groupA.matchSchedules - russiaSaudiArabiaMatch

        GroupsPhaseMetadata(Set(Group("A", groupATeams, matchSchedules))) should
          throwA(new IllegalArgumentException("requirement failed: all teams must play against each other"))
      }
    }
  }

  "GroupsPhase match schedules" >> {
    val phase = new GroupsPhaseMetadata(allGroups)

    "Get a match event given teams in home/visitor order" >> {
      val matchSchedule = phase.getMatchSchedule("Argentina", "Iceland")

      matchSchedule must be equalTo Some(argentinaIcelandMatch)
    }

    "Get a match event given teams in visitor/home order" >> {
      val matchSchedule = phase.getMatchSchedule("Iceland", "Argentina")

      matchSchedule must be equalTo Some(argentinaIcelandMatch)
    }

    "Get a match event between teams that don't belong to the same group must return Empty" >> {
      phase.getMatchSchedule("Germany", "Argentina") must be empty
    }
  }

}
