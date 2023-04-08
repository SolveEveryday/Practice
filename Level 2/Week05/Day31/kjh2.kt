// 4 3 2 중심 2 3 4
// 시소짝꿍 = 평형을 이룸 = 탑승한 사람의 무게와 거리의 곱이 양쪽 다 같음
// 시소짝꿍이 몇 쌍 존재하는지 반환

// 완전탐색 O(N^2)이라 불가
// 1:1, 1:2, 2:3, 3:4의 비율이라면 짝꿍임

class Solution {
  fun solution(weights: IntArray): Long {
      val sittedPersons = mutableListOf<SittedPerson>()
  
      for ((idx, weight) in weights.withIndex()) {
          for (i in 2..4) {
              val sittedPerson = SittedPerson(weight * i, idx)
              sittedPersons.add(sittedPerson)
          }
      }
      
      val groups = sittedPersons.groupBy { it.weight }
      val bestPairs = mutableSetOf<Pair<SittedPerson, SittedPerson>>()
      
      for (group in groups) {
          val distinctSorted = group.value.distinctBy { it.index }.sortedBy { it.index }.toList()
          
          for (i in 0..distinctSorted.size-1) {
              for (j in i+1..distinctSorted.size-1) {
                  val bestPair = Pair(distinctSorted[i], distinctSorted[j])
                  bestPairs.add(bestPair)
              }
          }
      }
      
      return bestPairs.size.toLong()
  }
}

data class SittedPerson(val weight: Int, val index: Int) {
  override fun equals(other: Any?): Boolean {
      if (other == null || other !is SittedPerson) return false
      return index == other.index 
  }
  override fun hashCode(): Int = index.hashCode() * 31
}