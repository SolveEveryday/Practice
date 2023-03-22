class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char lChar = s.charAt(0);
        int lCount = 1;
        int rCount = 0;
        
        for (int i = 1; i < s.length(); i++) {
            if (lCount == rCount) {
                lCount = 1;
                rCount = 0;
                answer++;
                lChar = s.charAt(i);
                continue;
            }
            
            if (lChar == s.charAt(i)) {
                lCount++;
            } else {
                rCount++;
            }
        }
        
        return answer + 1;
    }
}