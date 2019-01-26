package ar.com.flow.sportslottery.domain

// TODO do we need team here?
case class TeamMatchResult(team: String, goalsFavor: Int, goalsAgainst: Int) {
  val points = if (goalsFavor == goalsAgainst) {
    1
  } else if (goalsFavor > goalsAgainst) {
    3
  } else {
    0
  }
}
