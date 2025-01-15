package programmers.y2025.m1.w3.a64062;

class Solution {
    public int solution(int[] stones, int k) {
        int l = 0, r = 0;
        for (int i : stones) {
            r = Math.max(r, i);
        }
        while (l <= r) {
            int m = (l + r) / 2;
            int count = 0;
            int max = 0;
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] - m <= 0) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 0;
                }
            }
            if (max + 1 > k) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(new int[]{2, 4}, 2) + "";
        System.out.println(s);
    }
}