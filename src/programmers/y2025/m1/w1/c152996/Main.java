package programmers.y2025.m1.w1.c152996;

import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Set<Integer> set = new TreeSet<>();
        long[] w = new long[1001];
        for (int i = 0; i < weights.length; i++) {
            set.add(weights[i]);
            w[weights[i]]++;
        }
        for (int i : set) {
            answer += w[i] * (w[i] - 1) / 2;
            if (i * 4 / 3 > 1000) continue;
            if (i % 3 == 0)
                answer += w[i] * w[i * 4 / 3];
            if (i * 3 / 2 > 1000) continue;
            if (i % 2 == 0)
                answer += w[i] * w[i * 3 / 2];
            if (i * 2 > 1000) continue;
            answer += w[i] * w[i * 2];
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(new int[]{100, 180, 360, 100, 270}) + "";
        System.out.println(s);
    }
}