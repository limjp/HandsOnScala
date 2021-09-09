def isValidSudoku(grid: Array[Array[Int]]): Boolean = {
  // requirement for sudoku is that every row, column and 3x3 square can only contain the numbers 1-9 once
  // requirement for modified Sudoku is to allow tesitng of partially-filled Sudoku grid
  // This means if it is a 0, ignore them. Just make sure the row, col and square has no repeat numbers
  !Range(0, 9).exists { i =>
    //Map when called on Range would return a collection of type Vector
    val row = Range(0, 9).map(grid(i)(_)).filterNot(_ == 0)
    val col = Range(0, 9).map(grid(_)(i)).filterNot(_ == 0)
    val square = Range(0, 9).map(j => grid((i % 3) * 3 + j % 3)((i / 3) * 3 + j / 3)).filterNot(_ == 0)
    row.distinct.length != row.length ||
      col.distinct.length != col.length ||
      square.distinct.length != square.length
  }
}

assert(isValidSudoku(Array(
  Array(3, 1, 6,   5, 7, 8,   4, 9, 2),
  Array(5, 2, 9,   1, 3, 4,   7, 6, 8),
  Array(4, 8, 7,   6, 2, 9,   5, 3, 1),

  Array(2, 6, 3,   0, 1, 0,   0, 8, 0),
  Array(9, 7, 4,   8, 6, 3,   0, 0, 5),
  Array(8, 5, 1,   0, 9, 0,   6, 0, 0),

  Array(1, 3, 0,   0, 0, 0,   2, 5, 0),
  Array(0, 0, 0,   0, 0, 0,   0, 7, 4),
  Array(0, 0, 5,   2, 0, 6,   3, 0, 0)
)) ==
  true
)

assert(isValidSudoku(Array(
  Array(3, 1, 6,   5, 7, 8,   4, 9, 3),
  Array(5, 2, 9,   1, 3, 4,   7, 6, 8),
  Array(4, 8, 7,   6, 2, 9,   5, 3, 1),

  Array(2, 6, 3,   0, 1, 0,   0, 8, 0),
  Array(9, 7, 4,   8, 6, 3,   0, 0, 5),
  Array(8, 5, 1,   0, 9, 0,   6, 0, 0),

  Array(1, 3, 0,   0, 0, 0,   2, 5, 0),
  Array(0, 0, 0,   0, 0, 0,   0, 7, 4),
  Array(0, 0, 5,   2, 0, 6,   3, 0, 0)
)) ==
  false
)