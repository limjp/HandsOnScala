def measureTime(f: => Unit) = {
  val start = System.currentTimeMillis()
  f
  val end = System.currentTimeMillis()
  println("Evaluation took " + (end - start) + " miliseconds")
}

measureTime(new Array[String](10 * 1000 * 1000).hashCode())

measureTime { //methods with a single argument can also be called with curly brackets
  new Array[String](100 * 1000 * 1000).hashCode()
}

// Here if we did not have f => then we would get 0 miliseconds for both cause f is evaluated at compile which means the interval between
// start and end would be 0