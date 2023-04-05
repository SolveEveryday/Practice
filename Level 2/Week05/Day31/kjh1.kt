// 개발언어, 지원 직군, 지원 경력 구분, 선호하는 소울푸드
// 조건을 만족하는 사람 중 코딩테스트 점수를 X점 이상 받은 사람은 몇 명인가?

// 완전탐색 = O(N*Q) 시간초과
// 조건에 대해 Set 각각 만들어두고 교집합 구하기 = O(N*Q) 시간초과

class Solution {
  fun solution(infos: Array<String>, queries: Array<String>): IntArray {
      val applicants = mutableListOf<Applicant>()
      
      for (info in infos) {
          val splited = info.split(" ")
          val applicant = Applicant(splited[0], splited[1], splited[2], splited[3], splited[4].toInt())
          applicants.add(applicant)
      }
      
      val answer = mutableListOf<Int>()
      for (query in queries) {
          val splited = query.replace("and ", "").split(" ")
          
          var filtered = applicants.asSequence()
          if (splited[0] != "-") {
              filtered = filtered.filter { it.language == splited[0] }
          }
          if (splited[1] != "-") {
              filtered = filtered.filter { it.group == splited[1] }
          }
          if (splited[2] != "-") {
              filtered = filtered.filter { it.experience == splited[2] }
          }
          if (splited[3] != "-") {
              filtered = filtered.filter { it.soulFood == splited[3] }
          }
          if (splited[4] != "-") {
              filtered = filtered.filter { it.score >= splited[4].toInt() }
          }
          
          val count = filtered.count()
          answer.add(count)
      }
      
      return answer.toIntArray()
  }
}

data class Applicant(
  val language: String,
  val group: String,
  val experience: String,
  val soulFood: String,
  val score: Int
)