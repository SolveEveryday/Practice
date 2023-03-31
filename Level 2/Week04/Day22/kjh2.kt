class Solution {
  fun solution(k: Int, ranges: Array<IntArray>): DoubleArray {
      val ubaksoo = mutableListOf<Pair<Int, Int>>()
      ubaksoo.add(Pair(0, k))
      
      for (i in 0..k-1) {
          val (x, y) = ubaksoo.last()
          val next = if (y % 2 == 0) y / 2 else y * 3 + 1
          
          ubaksoo.add(Pair(i, next))
      }
      
      val integrals = mutableListOf<Double>()
      for (i in 0..k-2) {
          val (x1, y1) = ubaksoo[i]
          val (x2, y2) = ubaksoo[i+1]
          
          val integral = getIntegral(x1, y1, x2, y2, i, i+1)
          integrals.add(integral)
      }
      
      val answer = mutableListOf<Double>()
      for (range in ranges) {
          val (from, relativeTo) = range
          val to = k - relativeTo - 1
          
          answer.add(integrals.slice(from..to).sum())
      }
      
      return answer.toDoubleArray()
  }
  
  fun getIntegral(x1: Int, y1: Int, x2: Int, y2: Int, from: Int, to: Int): Double {
      val m = (y2-y1).toDouble() / (x2-x1).toDouble()
      val d = y1 - (m * x1)
      
      return getIntegral(m, d, from, to)
  }
  
  fun getIntegral(m: Double, d: Int, from: Int, to: Int) = getIntegral(m, d.toDouble(), from.toDouble(), to.toDouble())
  
  fun getIntegral(m: Double, d: Double, from: Double, to: Double): Double {
      return m * (to*to - from*from) / 2 + d * (to - from)
  }
}