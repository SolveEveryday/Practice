import java.util.Deque
import java.util.LinkedList

class Solution {
    fun solution(s: String): String {
        val answer = StringBuilder()

        val dq: Deque<Char> = LinkedList()

        for (c in s) {
            if (dq.isEmpty()) dq.addLast(c.uppercaseChar())
            else {
                if (c == ' ') {
                    dq.addLast(' ')
                }

                if (c.isLetter() || c.isDigit()) {
                    if (dq.peekLast() == ' ') {
                        dq.addLast(c.uppercaseChar())
                    } else {
                        dq.addLast(c.lowercaseChar())
                    }
                }
            }
        }

        dq.forEach { answer.append(it) }

        return answer.toString()
    }
}