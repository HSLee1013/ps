package programmers.y2024.m12.w2.c17679;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}) + "";
        System.out.println(s);
    }
}

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        int[][] box = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        while (true) {
            Queue<int[]> queue = new ArrayDeque<>();
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char cur = map[i][j];
                    if (cur == ' ') continue;
                    if (map[i + 1][j] != cur || map[i][j + 1] != cur || map[i + 1][j + 1] != cur)
                        continue;
                    queue.add(new int[]{i, j});
                }
            }
            if (queue.isEmpty()) break;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int curx = cur[0] + box[i][0];
                    int cury = cur[1] + box[i][1];
                    if (map[curx][cury] == ' ')
                        continue;
                    map[curx][cury] = ' ';
                    answer++;
                }
            }
            for (int i = m - 1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] != ' ') continue;
                    int k = i - 1;
                    while (k >= 0 && map[k][j] == ' ') k--;
                    if (k < 0) continue;
                    map[i][j] = map[k][j];
                    map[k][j] = ' ';
                }
            }
        }
        return answer;
    }
}