package programmers.y2025.m1.w3.b12936;

import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        long f = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            f *= i;
        }

        int count = 0;
        k--;
        while (count < n) {
            f = f / (n - count);
            answer[count++] = list.remove((int) (k / f));
            k = k % f;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = Arrays.toString(solution.solution(3, 1)) + "";
        System.out.println(s);
    }
}