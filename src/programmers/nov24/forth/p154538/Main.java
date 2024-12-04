package programmers.nov24.forth.p154538;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(10, 40, 5) + "";
        System.out.println(s);
    }
}

class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        dp[x] = 1;
        for (int i = x + 1; i <= y; i++) {
            int result = Integer.MAX_VALUE;
            if (i - n > 0 && dp[i - n] > 0)
                result = Math.min(dp[i - n] + 1, result);
            if (i % 2 == 0 && dp[i / 2] > 0)
                result = Math.min(dp[i / 2] + 1, result);
            if (i % 3 == 0 && dp[i / 3] > 0)
                result = Math.min(dp[i / 3] + 1, result);
            if (result != Integer.MAX_VALUE)
                dp[i] = result;
        }
        return dp[y] > 0 ? dp[y] - 1 : -1;
    }
}