// 맨해튼 거리 = |y2-y1|+|x2-x1|
// 거리두기 위반 = 맨해튼 거리 2 이하, 사이에 파티션 없음
// 거리두기 위반 사례 나열
    // 상하좌우
    // 2칸 상하좌우, 파티션 없음
    // 대각선, 파티션 2개 미만
// 파티션을 벽으로 취급하고, 두 응시자 사이의 거리가 2 이하인게 있다면 위반
// 플로이드 와샬

class Solution {
  fun solution(places: Array<Array<String>>): IntArray {
      val answer = IntArray(places.size)
      
      for ((idx, place) in places.withIndex()) {
          answer[idx] = if (hasViolation(place)) 0 else 1
      }
      
      return answer
  }
  
  fun hasViolation(place: Array<String>): Boolean {
      val distance = initDistance(place)
      
      for (via in 0..24) {
          for (from in 0..24) {
              for (to in 0..24) {
                  val shortcut = distance[from][via] + distance[via][to]
                  if (shortcut < distance[from][to]) {
                      distance[from][to] = shortcut
                  }
              }
          }
      }
      
      for (from in 0..24) {
          for (to in from+1..24) {
              val isExaminee = place[from/5][from%5] == 'P' && place[to/5][to%5] == 'P'
              if (!isExaminee) continue
              
              if (distance[from][to] <= 2) return true
          }
      }
      
      return false
  }
  
  fun initDistance(place: Array<String>): Array<IntArray> {
      val distance = Array(25) { IntArray(25) { 100 } }
      
      val dy = arrayOf(0, 0, -1, 1)
      val dx = arrayOf(-1, 1, 0, 0)
      for (y in 0..4) {
          for (x in 0..4) {
              if (place[y][x] == 'X') continue
              
              val fromIdx = y*5+x
              distance[fromIdx][fromIdx] = 0
              
              for (d in 0..3) {
                  val aroundY = y + dy[d]
                  val aroundX = x + dx[d]
                  
                  val outOfIndex = aroundY < 0 || aroundX < 0 || aroundY >= 5 || aroundX >= 5
                  if (outOfIndex) continue
                  
                  if (place[aroundY][aroundX] == 'X') continue
                  
                  val toIdx = aroundY * 5 + aroundX
                  distance[fromIdx][toIdx] = 1
              }
          }
      }
      
      return distance
  }
}