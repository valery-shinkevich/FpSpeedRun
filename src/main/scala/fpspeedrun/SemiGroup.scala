package fpspeedrun

trait SemiGroup[T] {
  def combine(x: T, y: T): T
}

object SemiGroup {

  import syntax.semigroup._

  object Laws {
    def associativity[T: SemiGroup](x: T, y: T, z: T): Boolean = {
      ((x |+| y) |+| z) == (x |+| (y |+| z))
    }
  }

}
