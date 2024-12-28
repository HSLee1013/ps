package programmers.dec24.forth.p178870;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int l = -1, r = 0;
        int sum = sequence[0];
        int length = Integer.MAX_VALUE;
        while (l < r && r < sequence.length) {
            if (sum == k) {
                if (r - l < length) {
                    length = r - l;
                    answer[0] = l + 1;
                    answer[1] = r;
                }
                l++;
                sum -= sequence[l];
            } else if (sum < k) {
                r++;
                if (r < sequence.length) {
                    sum += sequence[r];
                }
            } else {
                l++;
                sum -= sequence[l];
            }
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = Arrays.toString(solution.solution(new int[]{1, 2, 3, 4, 5}, 7)) + "";
        System.out.println(s);
    }
}