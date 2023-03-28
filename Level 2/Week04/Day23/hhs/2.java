package pro_42584;

public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < answer.length; i++) {
            int time = 0;
            for (int j = i + 1; j < answer.length; j++) {
                time++;
                if (prices[i] > prices[j]) break;
            }
            answer[i] = time;
        }

        return answer;
    }
}
