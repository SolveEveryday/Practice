import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answerIndex = 0;
        List<Integer> l = new ArrayList<>();
        
        for (int[] command : commands) {
            int start = command[0];
            int end = command[1];
            int target = command[2];

            l.clear();
            for (int i = start - 1; i < end; i++) {
                l.add(array[i]);
            }
            
            Collections.sort(l);
            answer[answerIndex++] = l.get(target - 1);
        }
        
        return answer;
    }
}