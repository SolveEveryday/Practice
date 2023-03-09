import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] alphabets = new int[26];
        Arrays.fill(alphabets, -1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            answer[i] = (alphabets[ch - 'a'] == -1) ? -1 : i - alphabets[ch - 'a'];
            alphabets[ch - 'a'] = i;
        }
        return answer;
    }
}