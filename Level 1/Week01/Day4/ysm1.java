import java.util.Stack;

class Solution {
    int answer = 0;
    Stack<Integer> s = new Stack<Integer>();
    
    void putStack(int input) {

        
        if(s.empty()) {
            s.push(input);
            return;
        }
        int number = s.peek();
        if(number == input) {
            s.pop();
            answer+=2;
            return;
        }

        s.push(input);
    }
    
    public int solution(int[][] board, int[] moves) {
      
        
        for(int x=0;x<moves.length;x++) {
            for(int y=0;y<board.length;y++){
                
                if(board[y][moves[x]-1] == 0) continue;
                int out = board[y][moves[x]-1];
                board[y][moves[x]-1] = 0;
                putStack(out);
                break;
            }
            
        }
        return answer;
    }
}