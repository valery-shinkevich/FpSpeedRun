package fpspeedrun

case class Ratio(num: Int, den: Int) {

  def === (that: Ratio): Boolean = num.toLong * that.den == den.toLong * that.num

}

object Ratio{
  def eqRatio: Eq[Ratio] = (a: Ratio, b: Ratio) => a.num.toLong * b.den == a.den.toLong * b.num
}