import fpspeedrun._
import fpspeedrun.syntax.eq._

Ratio(1,2) === Ratio(1,2)
Ratio(2,4) === Ratio(3,6)

val l1 = List(Ratio(1,2), Ratio(1,2))
val l2 = List(Ratio(3,6), Ratio(2,4))

l1 === l2