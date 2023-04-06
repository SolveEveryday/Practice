class Solution {
  val chars = "AEIOU"
  
  fun solution(word: String): Int {
      var order = 1
      var curWord = "A"
      
      while (curWord != word) {
          curWord = nextWord(curWord)
          order++
      }
      
      return order
  }
  
  fun nextChar(curChar: Char): Char {
      if (curChar == chars.last()) return 0.toChar()
      return chars[chars.indexOf(curChar)+1]
  }
  
  fun nextWord(word: String): String {
      if (word.length < 5) return word + "A"

      var curWord = word
      while (curWord.last() == chars.last()) {
          curWord = curWord.substring(0 until curWord.length-1)
      }
      if (curWord.length == 0) return ""

      return curWord.substring(0 until curWord.length-1) + nextChar(curWord.last())
  }
}