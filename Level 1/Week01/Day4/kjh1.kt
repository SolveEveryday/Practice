import java.util.*;

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        val sections = Array<Stack<Int>>(board[0].size) { Stack<Int>() }
        
        for (secIdx in 0..board[0].size-1) {
            for (i in board.size-1 downTo 0) {
                val doll = board[i][secIdx]
                if (doll == 0) break
                sections[secIdx].push(doll)
            }
        }
        
        var goneDolls = 0
        
        val basket = Stack<Int>()
        for (move in moves) {
            val secIdx = move-1
            if (sections[secIdx].isEmpty()) continue
            
            val pickedDoll = sections[secIdx].pop()
            if (!basket.isEmpty() && basket.peek() == pickedDoll) {
                basket.pop()
                goneDolls += 2
                continue
            }
            basket.push(pickedDoll)
        }
        
        return goneDolls
    }
}