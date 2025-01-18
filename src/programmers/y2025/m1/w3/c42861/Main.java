package programmers.y2025.m1.w3.c42861;

import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<int[]>[] list = new List[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] c : costs) {
            list[c[0]].add(new int[]{c[1], c[2]});
            list[c[1]].add(new int[]{c[0], c[2]});
        }
        boolean[] checked = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        checked[0] = true;
        pq.addAll(list[0]);
        int count = 0;
        while (count < n - 1) {
            int[] cur = pq.poll();
            if (checked[cur[0]]) continue;
            answer += cur[1];
            checked[cur[0]] = true;
            count++;
            for (int[] c : list[cur[0]]) {
                if (checked[c[0]]) continue;
                pq.add(c);
            }
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}) + "";
        System.out.println(s);
    }
}