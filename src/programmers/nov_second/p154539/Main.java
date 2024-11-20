package programmers.nov_second.p154539;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = Arrays.toString(solution.solution(new int[]{9, 1, 5, 3, 6, 2}));
        System.out.println(s);
    }
}

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        answer[answer.length - 1] = -1;
        for (int i = numbers.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] < numbers[j]) {
                    answer[i] = numbers[j];
                    break;
                } else {
                    if (answer[j] == -1) {
                        answer[i] = -1;
                        break;
                    }
                    if (numbers[i] < answer[j]) {
                        answer[i] = answer[j];
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
