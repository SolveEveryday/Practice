import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i : arr) {
            min = Math.min(i, min);
        }
        
        int[] answer = new int[arr.length - 1];
        
        int index = 0;
        for (int i : arr) {
            if (i == min) continue;
            answer[index++] = i; 
        }
        
        return answer;
    }
}