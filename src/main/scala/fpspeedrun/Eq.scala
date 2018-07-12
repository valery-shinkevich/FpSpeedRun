package fpspeedrun

import fpspeedrun.syntax.eq._

trait Eq[T] {
  def ===(a: T, b: T): Boolean
}

object Eq {
  implicit def eqList[T](implicit f: Eq[T]): Eq[List[T]] =
    (a: List[T], b: List[T]) => if (a.length != b.length) false else a.zip(b).forall { case (x, y) => x === y }
}