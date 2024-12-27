package programmers.dec24.forth.p64061;

import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer>[] stack = new Stack[board[0].length];
        Stack<Integer> result = new Stack<>();
        for (int i = 0; i < board[0].length; i++) {
            stack[i] = new Stack<>();
            for (int j = board.length - 1; j >= 0; j--) {
                if (board[j][i] == 0)
                    continue;
                stack[i].push(board[j][i]);
            }
        }
        for (int i = 0; i < moves.length; i++) {
            if (stack[moves[i] - 1].isEmpty())
                continue;
            int cur = stack[moves[i] - 1].pop();
            if (!result.isEmpty() && result.peek() == cur) {
                result.pop();
                answer += 2;
            } else {
                result.push(cur);
            }
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4}) + "";
        System.out.println(s);
    }
}