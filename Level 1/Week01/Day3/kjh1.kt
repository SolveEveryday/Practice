class Solution {
  fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
      val answer = mutableListOf<Int>()
      for (command in commands) {
          val (i, j, k) = command
          answer.add(getIJKNum(array, i, j, k))
      }
      return answer.toIntArray()
  }

  fun getIJKNum(array: IntArray, i: Int, j: Int, k: Int): Int {
      return array.slice(i-1..j-1).sorted()[k-1]
  }
}