import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        List<Stack<Integer>> stacks = new ArrayList<>();
        Stack<Integer> baguni = new Stack<>();

        for (int i = 0; i <= board.length; i++) {
            stacks.add(new Stack<>());
        }

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) continue;
                stacks.get(j + 1).push(board[i][j]);
            }
        }

        for (int move : moves) {
            Stack<Integer> stack = stacks.get(move);

            if (!stack.isEmpty()) {
                int peek = stack.pop();

                if (!baguni.isEmpty() && baguni.peek() == peek) {
                    answer += 2;
                    baguni.pop();
                    continue;
                }
                baguni.push(peek);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4}));
    }
}