class Solution {
  fun solution(sizes: Array<IntArray>): Int {
      val widthMax = sizes.map { it[0] }.maxOrNull()!!
      val heightMax = sizes.map { it[1] }.maxOrNull()!!
      
      println("$widthMax $heightMax")
      
      if (widthMax > heightMax) {
          var allFit = true
          
          for (h in 0..heightMax) {
              allFit = true
              for (size in sizes) {
                  val fit = (size[0] <= h && size[1] <= widthMax)
                      || (size[0] <= widthMax && size[1] <= h)
                  if (!fit) {
                      allFit = false
                      break
                  }
              }
              
              if (allFit) {
                  return h * widthMax
              }
          }
      }
      
      for (w in 0..widthMax) {
          var allFit = true
          
          for (size in sizes) {
              allFit = true
              val fit = (size[0] <= w && size[1] <= heightMax)
                  || (size[0] <= heightMax && size[1] <= w)
              if (!fit) {
                  allFit = false
                  break
              }
          }
          
          if (allFit) {
              return w * heightMax
          }
      }
      
      return 0
  }
}