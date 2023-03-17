import java.util.*;

class Solution {
    static int[][] supojas = new int[][]{{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
    
    public int getAnswerCount(int[] answers, int[] supoja) {
        int count = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == supoja[i % supoja.length]) count++;
        }
        
        return count;
    }
    
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        
        int[] total = new int[3];
        int i = 0;
        for (int[] supoja : supojas) {
            total[i] = getAnswerCount(answers, supojas[i]);
            i++;
        }
        
        int max = Arrays.stream(total).max().getAsInt();
        
        for (int j = 0; j < 3; j++) {
            if (total[j] == max) {
                answer.add(j + 1);
            }
        }
        
        return answer.stream()
            .mapToInt(v -> v)
            .toArray();
    }
}