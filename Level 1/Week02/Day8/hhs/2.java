import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] dp = new int[n + 2];
        Arrays.fill(dp, 1);
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for (int l : lost) {
            dp[l]--;
        }
        
        for (int r : reserve) {
            dp[r]++;
        }
        
        System.out.println(Arrays.toString(dp));
        
        for (int r : reserve) {
            if (dp[r] == 2 && dp[r - 1] == 0) {
                dp[r - 1]++;
                dp[r]--;
            }
            
            if (dp[r] == 2 && dp[r + 1] == 0) {
                dp[r + 1]++;
                dp[r]--;
            }
        }
        
        System.out.println(Arrays.toString(dp));
        
        return (int) Arrays.stream(dp).filter(x -> (x > 0)).count() - 2;
    }
}