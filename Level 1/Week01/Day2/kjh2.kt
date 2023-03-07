class Solution {
  fun solution(numbers: IntArray): IntArray {
      val twoSums = mutableSetOf<Int>()
      
      for (i in 0..numbers.size-1) {
          for (j in i+1..numbers.size-1) {
              twoSums.add(numbers[i] + numbers[j])
          }
      }
      
      return twoSums.sorted().toIntArray()
  }
}