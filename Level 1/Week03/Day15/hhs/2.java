import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int answer = 0;

        for (int i = score.length % m; i < score.length; i += m) {
            int min = k;

            for (int j = i; j < i + m; j++) {
                min = Math.min(min, score[j]);
            }

            answer += min * m;
        }

        return answer;
    }
}