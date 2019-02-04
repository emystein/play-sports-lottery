package ar.com.flow.sportslottery.domain

case class MatchResult(matchSchedule: MatchSchedule, homePoints: Int, visitorPoints: Int) {
  val homeScore = HomeTeamScore(matchSchedule.homeTeam, homePoints)
  val visitorScore = VisitorTeamScore(matchSchedule.visitorTeam, visitorPoints)
  val teamScores = Set(homeScore, visitorScore)

  def forTeam: Map[String, TeamMatchResult] = {
    val result = for {
      teamScore1 <- teamScores
      teamScore2 <- teamScores
      if teamScore1 != teamScore2
    } yield teamScore1.team -> TeamMatchResult(teamScore1, teamScore2)

    result.toMap
  }

  val winner = WinnerOf(homeScore, visitorScore)
}

trait TeamMatchPoints extends Ordered[TeamMatchPoints] {
  val goalsFavor: Int
  val goalsAgainst: Int
  def goalDifference: Int = goalsFavor - goalsAgainst
  val points: Int

  override def compare(that: TeamMatchPoints): Int = (points + goalDifference) compare (that.points + that.goalDifference)
}

// TODO convert to Monoid
case object ZeroMatchPoints extends TeamMatchPoints {
  override val goalsFavor: Int = 0
  override val goalsAgainst: Int = 0
  override val points: Int = 0
}

object SumMatchPoints {
  def apply(one: TeamMatchPoints, another: TeamMatchPoints) = {
    new TeamMatchPoints {
      override val goalsFavor: Int = one.goalsFavor + another.goalsFavor
      override val goalsAgainst: Int = one.goalsAgainst + another.goalsAgainst
      override val points: Int = one.points + another.points
    }
  }
}

case class TeamMatchResult(teamScore: TeamScore, opponentScore: TeamScore) extends TeamMatchPoints {
  val goalsFavor: Int = teamScore.score
  val goalsAgainst: Int = opponentScore.score

  val points = WinnerOf(teamScore, opponentScore) match {
    case None => 1
    case Some(team) => if (team == teamScore.team) 3 else 0
  }
}

object WinnerOf {
  def apply(homeScore: TeamScore, visitorScore: TeamScore) = {
    if (homeScore.score == visitorScore.score) {
      None
    } else if (homeScore.score > visitorScore.score) {
      Some(homeScore.team)
    } else {
      Some(visitorScore.team)
    }
  }
}
