package programmers.y2024.m12.w1.c12938;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = Arrays.toString(solution.solution(2, 8)) + "";
        System.out.println(s);
    }
}

class Solution {
    public int[] solution(int n, int s) {
        if (n > s)
            return new int[]{-1};
        int[] answer = new int[n];
        int rem = s % n;
        int div = s / n;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = div + (rem-- > 0 ? 1 : 0);
        }
        return answer;
    }
}