class Solution {
  fun solution(a: Int, b: Int): Long {
      val (x, y) = Pair(a.toLong(), b.toLong())
      
      if (x > y) {
          return (y..x).sum()
      }
      return (x..y).sum()
  }
}