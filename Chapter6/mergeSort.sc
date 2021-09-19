// Merge sort is most commonly applied to Array[Int]. However, there is no reason it cannot be applied to any data structure that is indexed such as Vectors or Sets
// To allow that you must change the function signature of the function from this: def mergeSort(items: Array[Int]): Array[Int] to the below
// Implicit Ordering[T] is context bound syntax
// Previously we also created an Array[Int] to store the output but we must change that as well
def mergeSort[T: Ordering](items: IndexedSeq[T]): IndexedSeq[T] = {
  if (items.length <= 1) items
  else {
    val (left, right) = items.splitAt(items.length / 2)
    val (sortedLeft, sortedRight) = (mergeSort(left), mergeSort(right))
    var (leftIdx, rightIdx) = (0,0)
    val output = IndexedSeq.newBuilder[T]
    while (leftIdx < sortedLeft.length || rightIdx < sortedRight.length) {
      val takeLeft = (leftIdx < sortedLeft.length, rightIdx < sortedRight.length) match {
        case (true, false) => true
        case (false, true) => false
        case (true, true) => Ordering[T].lt(sortedLeft(leftIdx), sortedRight(rightIdx)) // With Array[Int] as they are both Ints we just use < operator but with indexedSeq they
          // don't have such an operator so must use new one
      }
      if (takeLeft) {
        output += sortedLeft(leftIdx)
        leftIdx += 1
      } else {
        output  += sortedRight(rightIdx)
        rightIdx += 1
      }
    }
    output.result()
  }
}

println(mergeSort(Array(1)).mkString)
println(mergeSort(Array(2,1)).mkString)
println(mergeSort(Array(4, 0, 1, 5,2, 3)).mkString)
