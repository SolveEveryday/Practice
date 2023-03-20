import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayInt = convertDays(today);
        
        int[] days = new int[26];
        List<Integer> answer = new ArrayList<>();
        
        for (String term : terms) {
            days[term.charAt(0) - 'A'] = Integer.parseInt(term.split(" ")[1]) * 28 - 1;
        }
        
        System.out.println(Arrays.toString(days));
        
        
        int index = 1;
        for (String privacy : privacies) {
            String d = privacy.split(" ")[0];
            char t = privacy.split(" ")[1].charAt(0);
            
            int pDay = convertDays(d) + days[t - 'A'];
            System.out.println(pDay);
            System.out.println(todayInt);
            System.out.println();
            
            if (pDay < todayInt) answer.add(index);
            index++;
        }
        
        return answer.stream()
            .mapToInt(i -> i)
            .toArray();
    }
    
    public int convertDays(String s) {
        String[] times = s.split("\\.");
        
        int year = Integer.parseInt(times[0]);
        int month = Integer.parseInt(times[1]);
        int day = Integer.parseInt(times[2]);
        
        return (year * 12 + month) * 28 + day;
    }
}