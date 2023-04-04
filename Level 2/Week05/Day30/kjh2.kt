import kotlin.math.max

class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        val elements = mutableListOf<Int>()
        
        for (flatIdx in left..right) {
            val (y, x) = Pair(flatIdx / n, flatIdx % n)
            
            val element = max(y, x).toInt() + 1
            elements.add(element)
        }
        
        return elements.toIntArray()
    }
}