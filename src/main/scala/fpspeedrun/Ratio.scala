package fpspeedrun

case class Ratio(num: Int, den: Int)

object Ratio {

  implicit def eqRatio: Eq[Ratio] = (a: Ratio, b: Ratio) => a.num.toLong * b.den == a.den.toLong * b.num

  import fpspeedrun.Ord.CompareResult

  implicit def ordRatio: Ord[Ratio] = new Ord[Ratio] {

    override def compare(a: Ratio, b: Ratio): CompareResult = (a.num.toLong * b.den, a.den.toLong * b.num) match {
      case (x, y) if x < y => CompareResult.LT
      case (x, y) if x == y => CompareResult.EQ
      case (x, y) if x > y => CompareResult.GT
    }

    override def ===(a: Ratio, b: Ratio): Boolean = compare(a, b) == CompareResult.EQ
  }
}