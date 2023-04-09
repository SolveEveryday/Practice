package pro_12978

import java.util.PriorityQueue

const val INF = Integer.MAX_VALUE

class Solution {

    fun solution(N: Int, road: Array<IntArray>, K: Int): Int {
        val map = Array(N + 1) { IntArray(N + 1) { INF } }

        for ((a, b, c) in road) {
            map[a][b] = map[a][b].coerceAtMost(c)
            map[b][a] = map[b][a].coerceAtMost(c)
        }

        val distance = IntArray(N + 1) {INF}
        distance[1] = 0

        val pq = PriorityQueue<Pair<Int, Int>> {
                o1, o2 -> o1.second - o2.second
        }

        pq.add(Pair(1, 0))

        while (pq.isNotEmpty()) {
            val (now, dist) = pq.poll()
            if (distance[now] < dist) continue

            for (i in 1..N) {
                val cost = dist + map[now][i]
                if (cost < distance[i]) {
                    distance[i] = cost
                    pq.add(Pair(i, cost))
                }
            }
        }

        println(distance.toString())

        return distance.count { x -> x <= K }
    }
}
