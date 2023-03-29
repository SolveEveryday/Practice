import kotlin.math.abs

class Solution {
    fun solution(n: Int): Int {
        var count = 0
        
        val queensCombination = getQueensCombination(n)
        for (queens in queensCombination) {
            if (!canAttack(queens)) {
                count++
            }
        }
        
        return count
    }
}

fun getQueensCombination(n: Int): MutableList<List<Queen>> {
    val combinations = mutableListOf<List<Queen>>()
    
    val queens = mutableListOf<Queen>()
    for (y in 0..n-1) {
        for (x in 0..n-1) {
            queens.add(Queen(y, x))
        }
    }
    
    fun generateCombinations(start: Int, combination: MutableList<Queen>) {
        if (combination.size == n) {
            combinations.add(combination.toList())
            return
        }

        for (i in start..queens.size-1) {
            combination.add(queens[i])
            generateCombinations(i+1, combination)
            combination.removeAt(combination.size-1)
        }
    }
    
    generateCombinations(0, mutableListOf())
    
    return combinations
}


fun canAttack(queens: List<Queen>): Boolean {
    if (queens.map { it.y }.distinct().count() < queens.size
        || queens.map { it.x }.distinct().count() < queens.size) {
        return true
    }
    
    for (i in 0..queens.size-2) {
        for (j in i+1..queens.size-1) {
            val queenI = queens[i]
            val queenJ = queens[j]
            
            if (abs(queenI.y - queenJ.y) == abs(queenI.x - queenJ.x)) {
                return true
            }
        }
    }
    
    return false
}

data class Queen(val y: Int, val x: Int)