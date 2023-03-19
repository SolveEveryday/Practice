class Solution {
  fun solution(answers: IntArray): IntArray {
      val supos = arrayOf(
          intArrayOf(1, 2, 3, 4, 5), 
          intArrayOf(2, 1, 2, 3, 2, 4, 2, 5),
          intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
      )
      
      val suposCorrect = intArrayOf(0, 0, 0)
      for (i in 0..answers.size-1) {
          val answer = answers[i]
          
          for ((idx, supo) in supos.withIndex()) {
              if (supo[i % supo.size] == answer) {
                  suposCorrect[idx]++
              }
          }
      }
      
      val maxCorrect = suposCorrect.maxOrNull() ?: 0
      return suposCorrect
              .mapIndexed { index, correct -> Pair(index, correct) }
              .filter { it.second == maxCorrect }
              .map { it.first + 1 }
              .toIntArray()
  }
}