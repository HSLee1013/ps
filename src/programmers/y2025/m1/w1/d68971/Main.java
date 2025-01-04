package programmers.y2025.m1.w1.d68971;

import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        boolean[][] graph = new boolean[n + 1][n + 1];
        for (int[] w : wires) {
            graph[w[0]][w[1]] = true;
            graph[w[1]][w[0]] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (!graph[i][j]) continue;
                boolean[][] temp = new boolean[n + 1][];
                for (int k = 1; k <= n; k++) {
                    temp[k] = Arrays.copyOf(graph[k], n + 1);
                }
                temp[i][j] = false;
                temp[j][i] = false;
                answer = Math.min(check(n, temp), answer);
            }
        }
        return answer;
    }

    private int check(int n, boolean[][] graph) {
        int[] result = new int[2];
        boolean[] visited = new boolean[n + 1];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            int count = 0;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                count++;
                for (int j = 1; j <= n; j++) {
                    if (!graph[cur][j] || visited[j]) continue;
                    visited[j] = true;
                    queue.add(j);
                }
            }
            result[index] = count;
            index++;
        }
        return Math.abs(result[0] - result[1]);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}) + "";
        System.out.println(s);
    }
}