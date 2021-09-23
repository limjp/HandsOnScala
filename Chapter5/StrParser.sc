trait StrParser[T] { def parse(s: String): T}

object StrParser{
  implicit object ParseInt extends StrParser[Int] {
    def parse(s: String) = s.toInt
  }

  implicit object ParseBoolean extends StrParser[Boolean]{
    def parse(s: String) = s.toBoolean
  }

  implicit object ParseDouble extends StrParser[Double]{
    def parse(s: String) = s.toDouble
  }
}

def parseFromString[T](s: String)(implicit parser: StrParser[T]) = {
  parser.parse(s)
}

// Here we create a helper method that seeks to parse Sequences. This method creates a new StrParser object that takes in Seq[T] and parses it
// Unlike the implicit ojbects we defined earlier which are singletons. The below is an implicit def. Depending on the type T, we would need a different
// StrParser[T] and require a different StrParser[Seq[T]]. -> can't just create a singleton object that takes Seq[T]
// This means implciit def ParseSeq would return a different StrParser each time it is called with a different type T.
implicit def ParseSeq[T](implicit p: StrParser[T]) = new StrParser[Seq[T]]{
  def parse(s: String) = s.split(',').toSeq.map(p.parse)
}

val args = Seq("123", "true", "7.5")
val myInt = parseFromString[Int](args(0))
val myBoolean = parseFromString[Boolean](args(1))
val myDouble = parseFromString[Double](args(2))

val mySeq = parseFromString[Seq[Boolean]]("true, false true")
println(mySeq)