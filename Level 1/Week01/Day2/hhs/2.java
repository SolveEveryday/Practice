import java.util.*;

class Solution {
    public void dfs(int depth, int parent, int[] values, int[] numbers, Set<Integer> set) {
        if (depth == 2) {
            set.add(values[0] + values[1]);
            return;
        }
        
        for (int i = 0; i < numbers.length; i++) {
            if (i == parent) continue;
            values[depth] = numbers[i];
            dfs(depth + 1, i, values, numbers, set);
        }
    }
    
    public int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();
        int[] values = new int[2];
        dfs(0, -1, values, numbers, set);
        
        return set.stream().mapToInt(i -> i).toArray();
    }
}