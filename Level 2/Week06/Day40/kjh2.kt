class Solution {
  fun solution(n: Int, k: Int): Int {
      val converted = n.toString(k)
      val nums = converted.split("0").map { it.toLongOrNull() ?: 1L }
      
      var answer = 0
      for (num in nums) {
          if (isPrime(num)) {
              answer++
          }
      }
      
      return answer
  }
  
  fun isPrime(num: Long): Boolean {
      if (num <= 1) return false
      
      var i = 2L
      while (i*i <= num) {
          if (num % i == 0L) return false
          i++
      }
      
      return true
  }
}