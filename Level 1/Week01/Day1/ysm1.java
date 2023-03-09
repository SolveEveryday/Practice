class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] check = new int[n+1];
        for(int x=2;x<=n;x++) {
            if(check[x] == 0) answer++;
            for(int y=1;y<n;y++) {
                if(y*x > n) break;
                check[y*x] = 1;
            }
        }
        return answer;
    }
}