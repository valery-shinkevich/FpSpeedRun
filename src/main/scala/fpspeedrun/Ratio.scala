package fpspeedrun

case class Ratio(num: Int, den: Int) {

  def === (that: Ratio): Boolean = num.toLong * that.den == den.toLong * that.num

}
