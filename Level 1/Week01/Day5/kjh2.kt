class Solution {
  fun solution(absolutes: IntArray, signs: BooleanArray): Int {
      var sum = 0
      for (i in 0..absolutes.size-1) {
          val absolute = absolutes[i]
          val sign = if (signs[i]) 1 else -1
          
          val number = absolute * sign
          
          sum += number
      }
      
      return sum
  }
}