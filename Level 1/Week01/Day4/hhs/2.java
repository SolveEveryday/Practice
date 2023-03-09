import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;
        
        for (int[] size : sizes) {
            int maxValue = Math.max(size[0], size[1]);
            int minValue = Math.min(size[0], size[1]);
            
            maxW = Math.max(maxW, maxValue);
            maxH = Math.max(maxH, minValue);
        }
        
        return maxW * maxH;
    }
}