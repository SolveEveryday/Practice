class Solution {
  fun solution(k: Int, m: Int, score: IntArray): Int {
      return score.sortedDescending().chunked(m).map {
          if (it.size < m) 0
          else it.minOrNull()!! * m
      }.sum()
  }
}