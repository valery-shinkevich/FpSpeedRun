package fpspeedrun

case class Ratio(num: Int, den: Int)

object Ratio{
  implicit def eqRatio: Eq[Ratio] = (a: Ratio, b: Ratio) => a.num.toLong * b.den == a.den.toLong * b.num
}