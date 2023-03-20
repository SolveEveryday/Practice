import java.time.*
import java.time.format.DateTimeFormatter

class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val termMap = terms.map { it.split(" ") }.map { it[0] to it[1].toInt() }.toMap()
        
        val expired = mutableListOf<Int>()
        for ((index, privacy) in privacies.withIndex()) {
            val (startDate, term) = privacy.split(" ")
            val pastMonths = getPastMonths(startDate, today)
            
            if (pastMonths >= termMap[term]!!) {
                expired.add(index + 1)
            }
        }
        
        return expired.toIntArray()
    }
    
    fun getPastMonths(startDate: String, endDate: String): Int {
        val dateFormat = DateTimeFormatter.ofPattern("yyyy.MM.dd")
        
        val start = LocalDate.parse(startDate, dateFormat)
        val end = LocalDate.parse(endDate, dateFormat)
        
        val period = Period.between(start, end)
        return period.years * 12 + period.months
    }
}