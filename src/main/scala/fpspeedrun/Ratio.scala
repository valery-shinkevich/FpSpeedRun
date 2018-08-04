package fpspeedrun

import scala.annotation.tailrec

case class Ratio(num: Int, den: Int)

object Ratio {

  implicit def eqRatio: Eq[Ratio] =
    (a: Ratio, b: Ratio) => a.num.toLong * b.den == a.den.toLong * b.num

  import fpspeedrun.Ord.CompareResult

  implicit def ordRatio: Ord[Ratio] = new Ord[Ratio] {

    override def compare(a: Ratio, b: Ratio): CompareResult =
      (a.num.toLong * b.den, a.den.toLong * b.num) match {
        case (x, y) if x < y  => CompareResult.LT
        case (x, y) if x == y => CompareResult.EQ
        case (x, y) if x > y  => CompareResult.GT
      }

    override def ===(a: Ratio, b: Ratio): Boolean =
      compare(a, b) == CompareResult.EQ
  }

  @tailrec
  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def sum(x: Ratio, y: Ratio): Ratio = {
    val num = x.num * y.den + y.num * x.den
    val den = x.den * y.den
    val g = gcd(num, den)
    Ratio(num / g, den / g)
  }

  def prod(x: Ratio, y: Ratio): Ratio = {
    val num = x.num * y.num
    val den = x.den * y.den
    val g = gcd(num, den)
    Ratio(num / g, den / g)
  }

  def div(x: Ratio, y: Ratio): Ratio = {
    val num = x.num * y.den
    val den = x.den * y.num
    val g = gcd(num, den)
    Ratio(num / g, den / g)
  }

  implicit val combineListSum: SemiGroup[Sum[Ratio]] = (x, y) =>
    Sum(sum(x.value, y.value))

  implicit val combineListProd: SemiGroup[Prod[Ratio]] = (x, y) =>
    Prod(prod(x.value, y.value))

  implicit val combineListDiv: SemiGroup[Div[Ratio]] = (x, y) =>
    Div(div(x.value, y.value))

}
