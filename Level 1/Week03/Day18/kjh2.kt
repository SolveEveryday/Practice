class Solution {
  fun solution(n: Int, m: Int, section: IntArray): Int {
      val unpaintedWalls = mutableListOf<Int>()
      section.forEach { unpaintedWalls.add(it) }
      
      var paintCount = 0
      while (unpaintedWalls.size > 0) {
          val unpaintedIdx = unpaintedWalls[0]
          paintCount++
          unpaintedWalls.removeAll { it >= unpaintedIdx && it < unpaintedIdx + m }
      }
      
      return paintCount
  }
}