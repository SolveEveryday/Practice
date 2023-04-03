// 던전 = 최소 필요 피로도, 소모 피로 필요도를 가짐 [최소, 소모]
// 최대한 많은 던전을 도는 수

// 완전탐색
// 중복불가 순열
import kotlin.math.max

class Solution {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var maxExps = 0
        
        fun updateMaxExps(currentK: Int = k, availableDungeons: List<IntArray> = dungeons.toList(), exps: Int = 0) {
            for (dungeon in availableDungeons) {
                val (required, consumed) = dungeon
                if (currentK < required) continue
                
                updateMaxExps(currentK-consumed, availableDungeons-dungeon, exps+1)
            }
            
            maxExps = max(exps, maxExps)
        }
        updateMaxExps()
        
        return maxExps
    }
}