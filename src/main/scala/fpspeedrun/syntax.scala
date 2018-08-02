package fpspeedrun

import fpspeedrun.Ord.CompareResult

object syntax {

  object eq {

    // Добавляем всем объектам, для которых определен (в зоне видимости) eq:Eq[T], оператор ===
    implicit class EqOps[T](val x: T) extends AnyVal {
      def ===(y: T)(implicit eq: Eq[T]): Boolean = eq.===(x, y)
    }

  }

  object ord {

    // Добавляем всем объектам, для которых определен (в зоне видимости) ord:Ord[T], метод compare и оператор ===
    implicit class OrdOps[T](val x: T) extends AnyVal {
      def compare(y: T)(implicit ord: Ord[T]): CompareResult = ord.compare(x, y)

      def ===(y: T)(implicit ord: Ord[T]): Boolean = ord.===(x, y)
    }

  }

  object semigroup {

    implicit class SemiGroupOps[T](val x: T) extends AnyVal {
      def combine(y: T)(implicit sg: SemiGroup[T]): T = sg.combine(x, y)

      def |+|(y: T)(implicit sg: SemiGroup[T]): T = combine(y)
    }

  }

}
