def retry[T](max: Int)(f: => T): T = {
  var tries = 0
  var result: Option[T] = None
  while (result == None) {
    try { result = Some(f)}
    catch {case e: Throwable =>
    tries += 1
    if (tries > max) throw e
    else {
      println(s"failed, retry $tries")
    }
    }
  }
  result.get
}

val httpbin = "https://httpbin.org"

retry(max = 5) {
  // Only succeeds with a 200 response
  // code 1/3 of the time
  requests.get(
    s"$httpbin/status/200,400,500"
  )
}
// retry is a generic function - means it takes any type. It takes a by-name parameter that computes a value of type T
// It returns T once code block is successful. Retry then wraps a code block of any type and it retries that block and return the first T it successfully computes
