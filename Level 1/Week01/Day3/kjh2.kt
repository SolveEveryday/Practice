import kotlin.math.pow

class Solution {
    fun solution(n: Int): Int {
        val trinary = toTrinary(n)
        return toDecimal(trinary.reversed())
    }
    
    fun toTrinary(decimal: Int): String {
        var digit = 3.pow(16)
        var num = decimal
        var trinary = ""
        
        while (digit > 0) {
            if (num >= digit * 2) {
                num -= digit * 2
                trinary += "2"
            } else if (num >= digit) {
                num -= digit
                trinary += "1"
            } else {
                trinary += if (trinary.isEmpty()) "" else "0"
            }
            digit /= 3
        }
        return trinary
    }
    
    fun toDecimal(trinary: String): Int {
        var decimal = 0
        for (i in trinary.length-1 downTo 0) {
            val digit = 3.pow(trinary.length-1-i)
            decimal += digit * (trinary[i] - '0')
        }
        return decimal
    }
}

fun Int.pow(n: Int): Int = toDouble().pow(n).toInt()