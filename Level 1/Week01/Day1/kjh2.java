import java.util.*;

class Solution {
  public int[] solution(String s) {
    int[] alphabetLastIdx = new int['z' - 'a' + 1];
    Arrays.fill(alphabetLastIdx, -1);

    List<Integer> answer = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      int lastIdx = alphabetLastIdx[ch - 'a'];
      if (lastIdx == -1) {
        answer.add(-1);
      } else {
        answer.add(i - lastIdx);
      }
      alphabetLastIdx[ch - 'a'] = i;
    }

    return answer.stream().mapToInt(Integer::intValue).toArray();
  }
}