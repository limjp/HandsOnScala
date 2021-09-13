sealed trait Geeks {
  val articles = "not done"
}

class Scala extends Geeks {
  override val article = "scala article"
}

class Java extends Geeks {
  override val article = "java article"
}

class Csharp extends Geeks {
  override val article = "csharp article"
}

object GFG {
  def main(args: Array[String]): Unit ={
    val s = new Scala
    val j = new Java
    val c = new Csharp
    println(checkArticle(s))
    println(checkArticle(j))
    println(checkArticle(c))
  }

  def checkArticle(Article: Geeks): String = Article match {
    case s: Scala => s.article
    case j: Java => j.article
    case c: Csharp => c.article
  }
}