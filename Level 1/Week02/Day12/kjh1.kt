class Solution {
  fun solution(arr: IntArray): IntArray {
      val minElement = arr.minOrNull()!!
      
      val list = arr.toMutableList()
      list.remove(minElement)

      if (list.size == 0) {
          return intArrayOf(-1)
      }
      return list.toIntArray()
  }
}