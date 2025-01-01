package programmers.y2024.m12.w4.f68645;

import java.util.Arrays;

class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int pat = 0;
        int num = 1;
        int index = 0;
        answer[index] = num++;
        while (num <= answer.length) {
            if (pat % 3 == 0) {
                int count = pat == 0 ? 1 : 0;
                while (index + count + pat * 2 / 3 < answer.length && answer[index + count + pat * 2 / 3] == 0) {
                    index += count + pat * 2 / 3;
                    answer[index] = num++;
                    count++;
                }
            } else if (pat % 3 == 1) {
                while (index + 1 < answer.length && answer[index + 1] == 0) {
                    index++;
                    answer[index] = num++;
                }
            } else {
                int count = 0;
                while (answer[index + count - n + pat / 3] == 0) {
                    index += count - n + pat / 3;
                    answer[index] = num++;
                    count++;
                }
            }
            pat++;
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = Arrays.toString(solution.solution(1000)) + "";
        System.out.println(s);
    }
}