import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<Integer>();
        for(int x=0;x<commands.length;x++) {
            int startIdx = commands[x][0] -1;
            int endIdx = commands[x][1] -1;
            int resultIdx = commands[x][2] -1;

            List<Integer> list = new ArrayList<Integer>();
            for(int y = startIdx;y<=endIdx;y++) {
                list.add(array[y]);
            }
            Collections.sort(list);
            answer.add(list.get(resultIdx));
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}