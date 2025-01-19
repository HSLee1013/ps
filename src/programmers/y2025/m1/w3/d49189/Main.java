package programmers.y2025.m1.w3.d49189;

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<Integer> list[] = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] e : edge) {
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        queue.add(1);
        int count = 1;
        while (count < n) {
            int size = queue.size();
            answer = 0;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j : list[cur]) {
                    if (visited[j]) continue;
                    visited[j] = true;
                    answer++;
                    count++;
                    queue.add(j);
                }
            }
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}) + "";
        System.out.println(s);
    }
}