class Solution {
    public int solution(int[][] sizes) {
        
        int max0 = 0;
        int max1 = 0;
        for(int y=0;y<sizes.length;y++) {
            if(sizes[y][0] < sizes[y][1]) {
                int tmp = sizes[y][0];
                sizes[y][0] = sizes[y][1];
                sizes[y][1] = tmp;
            }
            
            if(max0 < sizes[y][0]) max0 = sizes[y][0];
            if(max1 < sizes[y][1]) max1 = sizes[y][1];
        }
        int answer = max0 * max1;
        return answer;
    }
}
