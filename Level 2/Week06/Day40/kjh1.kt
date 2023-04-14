// 과제
// 기존 진행중인거 있으면 ㄱ거 멈추고 새로운 과제 시작
// 새로운 과제 끝나면 기존 과제 ㄱ
// 계획: 이름, 시작시간, 걸리는 시간
// 끝낸 순서 과제 이름

class Solution {
  fun solution(plans: Array<Array<String>>): Array<String> {
      val sortedPlans = mutableListOf<Plan>()
      for (plan in plans) {
          val (name, startTime, required) = plan
          val (startHour, startMinute) = startTime.split(":").map { it.toInt() }
          
          val start = Time(startHour, startMinute)
          val end = start.plus(required.toInt())
          
          val plan = Plan(name, start, end)
          sortedPlans.add(plan)
      }
      sortedPlans.sort()
      println(sortedPlans)

      var current = sortedPlans[0]
      val completed = mutableListOf<String>()
      while (sortedPlans.size > 0) {
          val priorities = sortedPlans.filter { it != current && it.start < current.end }
          if (priorities.size > 0) {
              current = priorities[0]
              continue
          }
          
          completed.add(current.name)
          sortedPlans.remove(current)
          
          if (sortedPlans.size == 0) break
          current = sortedPlans[0]
      }
      
      return completed.toTypedArray()
  }
}

data class Plan(val name: String, val start: Time, var end: Time): Comparable<Plan> {
  override fun compareTo(other: Plan) = when {
      other.start != start -> start.compareTo(other.start)
      else -> end.compareTo(other.end)
  }
}

data class Time(val hour: Int, val minute: Int): Comparable<Time> {
  fun plus(minutes: Int): Time {
      val newHour = hour + (minute+minutes) / 60
      val newMinute = (minute+minutes) % 60
      return Time(newHour, newMinute)
  }
  
  override fun compareTo(other: Time) = when {
      other.hour != hour -> hour - other.hour
      else -> minute - other.minute
  }
}