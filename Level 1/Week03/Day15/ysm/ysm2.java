import java.util.PriorityQueue;
import java.util.Collections;

    class Solution {
        public int solution(int k, int m, int[] score) {
            PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
            int answer = 0;
            
            for(int x=0;x<score.length;x++) {
                p.add(score[x]);
            }
            
            while(p.size() >= m) {
                
                int maxN = 1;
                
                for(int x=0;x<m;x++) {
                    if(x == m-1) {
                        maxN = p.peek();
                        answer += maxN*m;
                    }
                    
                    p.poll();
                }
            }
            
            return answer;
        }
    }