class Solution {
    public long solution(long n) {
        double num = Math.sqrt(n);
        long answer = -1L;
        if (!isDecimal(num)) {
            answer = (long) Math.pow(num + 1, 2);
        }
        return answer;
    }
    
    public static boolean isDecimal(double n) {
        return (n - (int) n) != 0;
    }
}