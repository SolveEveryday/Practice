import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> removedDup = new ArrayList<>();
        for (int element : arr) {
            if (removedDup.size() > 0 && element == removedDup.get(removedDup.size() - 1)) {
                continue;
            }
            removedDup.add(element);
        }

        return removedDup.stream().mapToInt(i -> i).toArray();
    }
}
