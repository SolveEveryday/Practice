class Solution {
  fun solution(s: String, n: Int): String {
      val lower = "abcdefghijklmnopqrstuvwxyz"
      val upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
      
      var pushed = ""
      
      for (ch in s) {
          if (ch == ' ') {
              pushed += " "
              continue
          }
      
          if (ch.isLowerCase()) {
              val idx = ((ch - 'a') + n) % 26
              pushed += lower[idx]
          } else {
              val idx = ((ch - 'A') + n ) % 26
              pushed += upper[idx]
          }
      }
      
      return pushed
  }
}
