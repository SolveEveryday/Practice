class Solution {
  fun solution(n: Long): Long {
      val sqrted = Math.floor(Math.sqrt(n.toDouble())).toLong()
      
      if (sqrted * sqrted < n) {
          return -1
      }
      return (sqrted + 1) * (sqrted + 1)
  }
}