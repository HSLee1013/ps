package programmers.y2025.m1.w2.b12978;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 1;
        int[][] graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                graph[i][j] = 500001;
            }
        }
        for (int i = 0; i < road.length; i++) {
            graph[road[i][0]][road[i][1]] = Math.min(graph[road[i][0]][road[i][1]], road[i][2]);
            graph[road[i][1]][road[i][0]] = Math.min(graph[road[i][1]][road[i][0]], road[i][2]);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        for (int i = 2; i <= N; i++) {
            if (graph[1][i] <= K) answer++;
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(6, new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4) + "";
        System.out.println(s);
    }
}