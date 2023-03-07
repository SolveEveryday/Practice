class Solution {
    public int solution(int n) {

        String change3 = Integer.toString(n,3);
        String reverseStr = "";
        for(int x=change3.length()-1;x>=0;x--) {
            reverseStr += change3.charAt(x);
        }

        return Integer.parseInt(reverseStr,3);
    }
}