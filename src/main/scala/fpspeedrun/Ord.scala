package fpspeedrun

import fpspeedrun.Ord.CompareResult
import fpspeedrun.syntax.ord._

trait Ord[T] extends Eq[T] {
  def compare(a: T, b: T): CompareResult
}

object Ord {


  implicit def ordList[T](implicit f: Ord[T]): Ord[List[T]] = new Ord[List[T]] {

    override def compare(a: List[T], b: List[T]): CompareResult =
      if (a.length == b.length)
        a.zip(b).collectFirst {
          case (x: Ratio, y: Ratio) if (x compare y) != CompareResult.EQ => x compare y
        }.getOrElse(CompareResult.EQ)
      else if (a.length > b.length) CompareResult.GT
      else
        CompareResult.LT


    override def ===(a: List[T], b: List[T]): Boolean = if (a.length != b.length) false else a.zip(b).forall { case (x, y) => x === y }
  }


  //  (a: List[T], b: List[T]) =>

  /*
  * Правило сравнения дробей с разными знаменателями: если a·d > b·c, то a/b > c/d, а если a·d < b·c, то a/b < c/d.
  */

  sealed trait CompareResult

  object CompareResult {

    case object LT extends CompareResult

    //less than
    case object EQ extends CompareResult

    //equals to
    case object GT extends CompareResult

    //greater than
  }

}