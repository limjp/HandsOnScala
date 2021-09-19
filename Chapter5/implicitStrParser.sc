trait StrParser[T]{ def parse(s: String): T}

object StrParser{
  implicit object ParseInt extends StrParser[Int]{
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

def parseFromConsole[T](implicit parser: StrParser[T]) = {
  parser.parse(scala.Console.in.readLine())
}

implicit def ParseSeq[T](implicit p: StrParser[T]) = new StrParser[Seq[T]] {
  def parse(s: String) = s.split(",").toSeq.map(p.parse)
}

val args = Seq("123", "true", "7.5")
val myInt = parseFromString[Int](args(0))
val myBoolean = parseFromString[Boolean](args(1))
val myDouble = parseFromString[Double](args(2))

val consoleInt = parseFromConsole[Int]