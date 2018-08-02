package fpspeedrun

trait SemiGroup[T] {
  def combine(x: T, y: T): T
}

object SemiGroup {

  object Laws {
    def associativity[T](x: T, y: T, z: T)(implicit semiGroup: SemiGroup[T]): Boolean = {
      import semiGroup.combine
      combine(combine(x, y), z) == combine(x, combine(y, z))
    }
  }

}
