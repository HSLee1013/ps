package programmers.dec24.forth.p12971;

class Solution {
    public int solution(int sticker[]) {
        if (sticker.length == 1)
            return sticker[0];
        int[] dp = new int[sticker.length];
        dp[0] = sticker[0];
        dp[1] = sticker[0];
        for (int i = 2; i < sticker.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
        }
        int[] dp2 = new int[sticker.length];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i = 2; i < sticker.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }
        return Math.max(dp[sticker.length - 2], dp2[sticker.length - 1]);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(new int[]{5, 1, 16, 17, 16}) + "";
        System.out.println(s);
    }
}