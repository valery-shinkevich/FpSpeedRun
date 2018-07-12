import fpspeedrun._

Ratio(1,2) === Ratio(1,2)
Ratio(2,4) === Ratio(3,6)

val l1 = List(Ratio(1,2), Ratio(1,2))
val l2 = List(Ratio(3,6), Ratio(2,4))

Eq.eq(l1,l2)(Ratio.eqRatio)