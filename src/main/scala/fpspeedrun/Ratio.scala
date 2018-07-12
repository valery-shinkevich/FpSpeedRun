package fpspeedrun

case class Ratio(num: Int, den: Int) {

  def === (that: Ratio): Boolean = num.toLong * that.den == den.toLong * that.num

}

object Ratio{
  def eqRatio = new Eq[Ratio] {
    override def ===(a: Ratio, b: Ratio): Boolean = a.num.toLong * b.den == a.den.toLong * b.num
  }
}