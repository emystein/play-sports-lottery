package ar.com.flow.sportslottery.domain

class MatchResult(val event: MatchEvent, val homeScore: Int, val visitorScore: Int) {
  val winner = {
    if (homeScore == visitorScore) {
      None
    } else if (homeScore > visitorScore) {
      Some(event.homeTeam)
    } else {
      Some(event.visitorTeam)
    }
  }

  def teamResults: Set[TeamMatchResult] = {
    Set(homeResult(), visitorResult())
  }

  def homeResult(): TeamMatchResult = {
    if (winner == None) {
      TeamMatchResult(event.homeTeam, 1, homeScore, visitorScore)
    } else if (winner == Some(event.homeTeam)) {
      TeamMatchResult(event.homeTeam, 3, homeScore, visitorScore)
    } else {
      TeamMatchResult(event.homeTeam, 0, homeScore, visitorScore)
    }
  }

  def visitorResult(): TeamMatchResult = {
    if (winner == None) {
      TeamMatchResult(event.visitorTeam, 1, visitorScore, homeScore)
    } else if (winner == Some(event.homeTeam)) {
      TeamMatchResult(event.visitorTeam, 0, visitorScore, homeScore)
    } else {
      TeamMatchResult(event.visitorTeam, 3, visitorScore, homeScore)
    }
  }
}
