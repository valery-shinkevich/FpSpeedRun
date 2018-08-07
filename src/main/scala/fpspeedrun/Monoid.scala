package fpspeedrun

trait Monoid[F] {
  def empty: F
  def op(a: F, b: F): F
}

object Monoid {

  object Laws {
    def associativity[T](x: T, y: T, z: T)(implicit m: Monoid[T]): Boolean = {
      m.op(m.op(x, y), z) == m.op(x, m.op(y, z))
    }

    def identity[T](x: T)(implicit m: Monoid[T]): Boolean = {
      m.op(m.empty, x) == x
    }
  }
}
