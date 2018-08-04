import fpspeedrun._
import fpspeedrun.syntax.ord._

Ratio(1,2) === Ratio(1,2)
Ratio(2,4) === Ratio(3,6)

val l1 = List(Ratio(1,2), Ratio(1,2))
val l2 = List(Ratio(3,6), Ratio(2,4))

l1 === l2

l1 compare l2

Ratio.sum(Ratio(3,4),Ratio(4,3))
Ratio.prod(Ratio(1,3),Ratio(2,4))
Ratio.div(Ratio(1,3),Ratio(2,4))

l1.reduceOption(Ratio.sum)
l2.reduceOption(Ratio.sum)

val listStrings = List("s1", "s2", "s3")
SemiGroup.combineList(listStrings)

SemiGroup.combineList(l1.map(Sum(_))).map(_.value)
SemiGroup.combineList(l2.map(Prod(_))).map(_.value)
SemiGroup.combineList(l2.map(Div(_))).map(_.value)
