import java.util.*

class Solution {
    lateinit var visited: Array<BooleanArray>
    lateinit var queue: Queue<Node>
    
    fun solution(board: Array<String>): Int {
        val robotNode = getRobotNode(board)
        
        visited = Array(board.size) { BooleanArray(board[0].length) { false } }
        visited[robotNode.y][robotNode.x] = true
        
        queue = LinkedList()
        queue.add(robotNode)
        
        while (queue.size > 0) {
            val (y, x, distance) = queue.poll()
            
            val possibleMoves = getPossibleMoves(board, y, x)
            
            for (possibleMove in possibleMoves) {
                val (nextY, nextX) = possibleMove
                if (board[nextY][nextX] == 'G') return distance + 1
                
                if (visited[nextY][nextX]) continue
                visited[nextY][nextX] = true
                
                queue.add(Node(nextY, nextX, distance + 1))
            }
        }
        
        return -1
    }
    
    fun getRobotNode(board: Array<String>): Node {
        for (y in 0..board.size-1) {
            for (x in 0..board[0].length-1) {
                if (board[y][x] == 'R') {
                    return Node(y, x, 0)
                }
            }
        }
        
        return Node(-1, -1, 0)
    }
    
    fun getPossibleMoves(board: Array<String>, y: Int, x: Int): MutableList<Pair<Int, Int>> {
        val possibleMoves = mutableListOf<Pair<Int, Int>>()
        
        // 상
        for (nextY in y..board.size-1) {
            if (nextY == board.size-1 || board[nextY+1][x] == 'D') {
                possibleMoves.add(Pair(nextY, x))
                break
            }
        }
        
        // 우
        for (nextX in x..board[0].length-1) {
            if (nextX == board[0].length-1 || board[y][nextX+1] == 'D') {
                possibleMoves.add(Pair(y, nextX))
                break
            }
        }
        
        // 하
        for (nextY in y downTo 0) {
            if (nextY == 0 || board[nextY-1][x] == 'D') {
                possibleMoves.add(Pair(nextY, x))
                break
            }
        }
        
        // 좌
        for (nextX in x downTo 0) {
            if (nextX == 0 || board[y][nextX-1] == 'D') {
                possibleMoves.add(Pair(y, nextX))
                break
            }
        }
        
        return possibleMoves
    }
}

data class Node(val y: Int, val x: Int, val distance: Int)