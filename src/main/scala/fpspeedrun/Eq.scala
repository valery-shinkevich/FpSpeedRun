package fpspeedrun

import fpspeedrun.syntax.eq._

trait Eq[T] {
  def ===(a: T, b: T): Boolean
}

object Eq {
  implicit def eqList[T](implicit f: Eq[T]): Eq[List[T]] =
    (a: List[T], b: List[T]) => a.length == b.length && a.zip(b).forall { case (x, y) => x === y }


  object laws {

    def symmetry[T: Eq](x: T, y: T): Boolean = (x === y) == (y === x)

    def transitivity[T: Eq](x: T, y: T, z: T): Boolean = !((x === y) && (y === z)) || (x === z)

    def reflectivity[T: Eq](x: T): Boolean = x === x
  }

}