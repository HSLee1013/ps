package programmers.dec24.first.p12987;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8}) + "";

        System.out.println(s);
    }
}

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int b = B.length - 1;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] < B[b]) {
                b--;
                answer++;
            }
        }
        return answer;
    }
}