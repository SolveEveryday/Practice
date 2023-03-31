package pro_142085

import java.util.Collections
import java.util.PriorityQueue

class Solution {
    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        var answer = 0
        val pq: PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())

        var mySoldier = n
        var card = k
        for (e in enemy) {
            pq.add(e)
            mySoldier -= e

            if (mySoldier < 0) {
                if (card > 0) {
                    mySoldier += pq.poll()
                    card--
                } else {
                    break
                }
            }
            answer++
        }

        return answer
    }
}

fun main() {
    val s = Solution()
    println(s.solution(7, 3, intArrayOf(4, 2, 4, 5, 3, 3, 1)))
}