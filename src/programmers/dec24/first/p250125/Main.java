package programmers.dec24.first.p250125;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(new String[][]{{"blue", "red", "orange", "red"}, {"red", "red", "blue", "orange"}, {"blue", "orange", "red", "red"}, {"orange", "orange", "red", "blue"}}, 1, 1) + "";
        System.out.println(s);
    }
}

class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < 4; i++) {
            int nx = h + dir[i][0];
            int ny = w + dir[i][1];
            if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) {
                continue;
            }
            if (board[nx][ny].equals(board[h][w]))
                answer++;
        }
        return answer;
    }
}