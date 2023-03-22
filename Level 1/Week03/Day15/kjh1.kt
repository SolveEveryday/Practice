class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val gymSuits = IntArray(n) { 1 }
        
        lost.forEach { gymSuits[it-1]-- }
        reserve.forEach { gymSuits[it-1]++ }
        
        for (i in 0..n-1) {
            val prev = gymSuits.getOrNull(i-1) ?: 1
            val current = gymSuits[i]
            val next = gymSuits.getOrNull(i+1) ?: 1
            
            if (current <= 1) {
                continue
            }

            if (prev == 0) {
                gymSuits[i]--
                gymSuits[i-1]++
            } else if (next == 0) {
                gymSuits[i]--
                gymSuits[i+1]++
            }
        }
        
        return gymSuits.filter { it >= 1 }.count()
    }
}