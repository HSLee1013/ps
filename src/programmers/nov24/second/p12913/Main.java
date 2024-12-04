package programmers.nov24.second.p12913;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}) + "";
        System.out.println(s);
    }
}

class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];
        dp[0] = Arrays.copyOf(land[0], land[0].length);
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                int max = 0;
                for (int k = 0; k < land[i].length; k++) {
                    if (j == k)
                        continue;
                    max = Math.max(max, dp[i - 1][k]);
                }
                dp[i][j] = land[i][j] + max;
            }
        }
        return Arrays.stream(dp[land.length - 1]).max().getAsInt();
    }
}