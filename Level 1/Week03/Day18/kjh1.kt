class Solution {
  fun solution(wallpaper: Array<String>): IntArray {
      val files = mutableListOf<File>()
      
      for (y in 0..wallpaper.size-1) {
          val line = wallpaper[y]
          for (x in 0..line.length-1) {
              val dot = line[x]
              if (dot == '#') {
                  files.add(File(y, x))
              }
          }
      }
      
      val minX = files.map { it.x }.minOrNull()!!
      val minY = files.map { it.y }.minOrNull()!!
      val maxX = files.map { it.x }.maxOrNull()!! + 1
      val maxY = files.map { it.y }.maxOrNull()!! + 1
      
      return intArrayOf(minY, minX, maxY, maxX)
  }
}

data class File(val y: Int, val x: Int)