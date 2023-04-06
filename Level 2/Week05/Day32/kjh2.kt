// k개의 수를 제거했을때 가장 큰 숫자
// O(N^2)으로 안되니 완전탐색 불가
// 최대 NlogN
// 0~n
// 0~n-3 중 가장 큰 자릿수
// 1~n-2 중 가장 큰 수
// 2~n-1 중 가장 큰 수
// 3~n중 가장 큰 수

// 현재 길이-더 뽑아야 할 개수-1

// 길이 10 뽑아야 할 개수 3
// 0~7 (0~9) 2
// 0~8 (0~8) 1
// 0~7 (0~7) 0

// i = k-1 downTo 0
// 0~(현재 길이-i)

// i = 

class Solution {
  fun solution(number: String, k: Int): String {
      var answer = ""
      
      var len = number.length
      var startIndex = 0
      for (i in len-k-1 downTo 0) {
          var maxDigit = 0
          var maxIndex = 0
          for (j in startIndex..number.length-i-1) {
              val num = Character.getNumericValue(number[j])
              if (num > maxDigit) {
                  maxDigit = num
                  maxIndex = j
              }
          }
          
          startIndex += maxIndex + 1
          len = number.length - startIndex
          answer += maxDigit
          println("$startIndex $len $answer")
          println("${number.length-i-1}")
      }
      
      return answer
  }
}