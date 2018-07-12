package fpspeedrun

import fpspeedrun.Ord.CompareResult

trait Ord[T] extends Eq[T] {
  def compare(x: T, y: T): CompareResult
}

object Ord {

  sealed trait CompareResult

  object CompareResult {

    case object LT //less than
    case object EQ //equals to
    case object GT //greater than
  }

}

