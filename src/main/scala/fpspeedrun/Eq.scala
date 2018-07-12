package fpspeedrun

trait Eq[T] {
  def ===(a: T, b: T): Boolean
}

object Eq {
  def eq[T](a: Seq[T], b: Seq[T])(f: Eq[T]): Boolean = {
    if (a.length != b.length) false
    else
      a.zip(b).forall { case (x, y) => f.===(x, y) }
  }
}