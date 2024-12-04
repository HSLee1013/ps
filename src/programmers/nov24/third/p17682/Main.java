package programmers.nov24.third.p17682;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution("1D2S#10S") + "";
        System.out.println(s);
    }
}

class Solution {
    public int solution(String dartResult) {
        int[] arr = Arrays.stream(dartResult.split("[SDT*#]")).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).toArray();
        int index = -1;
        for (char c : dartResult.toCharArray()) {
            if (c == 'S') {
                index++;
            } else if (c == 'D') {
                index++;
                arr[index] *= arr[index];
            } else if (c == 'T') {
                index++;
                arr[index] *= arr[index] * arr[index];
            } else if (c == '*') {
                arr[index] *= 2;
                if (index > 0)
                    arr[index - 1] *= 2;
            } else if (c == '#') {
                arr[index] *= -1;
            }
        }
        return Arrays.stream(arr).sum();
    }
}