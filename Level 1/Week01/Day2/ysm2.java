import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] numbers) {

        List<Integer> answer = new ArrayList<Integer>();
        int n = numbers.length;
        int[] check = new int[200];
        for(int y=0;y<n;y++) {
            for(int x=y+1;x<n;x++) {
                int num = numbers[y] + numbers[x];
                if(check[num] == 1) continue;
                answer.add(num);
                check[num] = 1;
            }
        }
        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}