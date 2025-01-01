package programmers.y2024.m11.w3.b42584;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = Arrays.toString(solution.solution(new int[]{5, 8, 9, 2, 5, 1, 3, 7, 4, 5})) + "";
        System.out.println(s);
    }
}

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = prices.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < prices.length; j++) {
                if (j == prices.length - 1 || prices[i] > prices[j]) {
                    answer[i] = j - i;
                    break;
                }
                if (prices[i] == prices[j]) {
                    answer[i] = answer[j] + j - i;
                    break;
                }
            }
        }
        return answer;
    }
}
