def binarySearch(items: Array[Int], target: Int): Int = {
  val start = 0
  val end = items.length
  var pointer = (0 + end) / 2
  while (items(pointer) != target) {
    if (items(pointer) > target) {
      pointer = (start + pointer) / 2
    } else pointer = (pointer + end) / 2
  }
  pointer
}

val a = Array(1,3,5,7,10)
val b = Array(-1, 0, 5, 10)

println(binarySearch(a, 10))
println(binarySearch(b, -1))