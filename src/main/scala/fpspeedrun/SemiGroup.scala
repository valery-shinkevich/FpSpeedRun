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

  implicit val stringSemiGroup: SemiGroup[String] =
    (x: String, y: String) => {
      x + y
    }

  def combineList[T: SemiGroup](list: List[T]): Option[T] =
    list.reduceOption((x, y) => x |+| y)

}

final case class Sum[T](value: T) extends AnyVal
final case class Prod[T](value: T) extends AnyVal
final case class Div[T](value: T) extends AnyVal
