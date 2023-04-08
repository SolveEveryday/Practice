class Solution {
  fun solution(progresses: IntArray, speeds: IntArray): ArrayList<Int> {
      val jobs = mutableListOf<Job>()
      for (i in 0 until speeds.size) {
          val progress = progresses[i]
          val speed = speeds[i]
          jobs.add(Job(progress, speed))
      }
      
      val answer = arrayListOf<Int>()
      while (jobs.size > 0) {
          while (jobs[0].progress < 100) {
              for (job in jobs) {
                  job.progress += job.speed
              }
          }
          
          var completed = 0
          while (jobs.size > 0 && jobs[0].progress >= 100) {
              jobs.removeAt(0)
              completed++
          }
          answer.add(completed)
      }
      
      return answer
  }
}

data class Job(var progress: Int, val speed: Int)