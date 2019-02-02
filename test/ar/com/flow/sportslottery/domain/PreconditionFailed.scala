package ar.com.flow.sportslottery.domain

object PreconditionFailed {
  def apply(reason: String) = {
    new IllegalArgumentException(s"requirement failed: $reason")
  }
}
