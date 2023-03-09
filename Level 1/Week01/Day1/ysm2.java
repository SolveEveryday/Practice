import java.util.HashMap;
class Solution {
    public int[] solution(String s) {
        
        int n = s.length();
        int[] answer = new int[n];
        HashMap<Character,Integer> map = new HashMap<>();
        for(int x=0;x<n;x++) {
            char word = s.charAt(x);
            if(map.get(word) == null) {
                answer[x] = -1;
                map.put(word,x);
                continue;
            }

            int where = x - map.get(word);
            answer[x] = where;
            map.replace(word,x);
            
        }
        return answer;
    }
}