package programmers.y2025.m1.w2.a135807;

import java.util.Arrays;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int max = Math.max(arrayA[0], arrayB[0]);
        for (int i = max; i > 1; i--) {
            boolean check = true;
            for (int j = 0; j < arrayA.length; j++) {
                if (arrayA[j] % i != 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                for (int j = 0; j < arrayB.length; j++) {
                    if (arrayB[j] % i == 0) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    return i;
                }
            }
            check = true;
            for (int j = 0; j < arrayB.length; j++) {
                if (arrayB[j] % i != 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                for (int j = 0; j < arrayA.length; j++) {
                    if (arrayA[j] % i == 0) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    return i;
                }
            }
        }
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(new int[]{10, 17}, new int[]{5, 20}) + "";
        System.out.println(s);
    }
}