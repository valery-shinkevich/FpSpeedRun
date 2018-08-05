package fpspeedrun

trait Monoid[F] {

  def zero: F
  def op(x: F, y: F): F

}

object Monoid {

      object Laws {
        def associativity[F:Monoid[_]](x: F, y: F, z: F)(implicit F:Eq[F]): Boolean = {

        }
      }

}
