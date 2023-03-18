class Solution {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int x=0;x<arr1.length;x++) {
            String result = "";
            String str = Integer.toBinaryString(arr1[x]);
            String str2 = Integer.toBinaryString(arr2[x]);
           
            while(str.length() != n) str = '0' + str;
            while(str2.length() != n) str2 = '0' + str2;

            for(int y=0;y<n;y++) {
                if(str.charAt(y) == '0' && str2.charAt(y) == '0') {
                    result += " ";
                    System.out.println("수민");
                    continue;
                }

                result += "#";
            }

            answer[x] = result;
        }

        
        return answer;
    }
}