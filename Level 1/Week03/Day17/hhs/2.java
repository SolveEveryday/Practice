import java.util.stream.*;

class Solution {
    public int getDivisorCount(int n) {
        int count = 0;
        
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) count++;
            else if (n % i == 0) count += 2;
        }
        
        return count;
    }
    
    public int solution(int number, int limit, int power) {
        return IntStream.range(1, number + 1)
            .map(i -> {
                int count = getDivisorCount(i);
                return (count <= limit) ? count : power;
            })
            .sum();
    }
}