package fpspeedrun

object syntax {

  object eq{
    // Добавляем всем объектам, для которых определен (в зоне видимости) eq:Eq[T], оператор ===
    implicit class EqOps[T](val x: T) extends AnyVal{
      def ===(y:T)(implicit eq:Eq[T]): Boolean = eq.===(x,y)
    }
  }

}
