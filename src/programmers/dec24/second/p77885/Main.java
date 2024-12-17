package programmers.dec24.second.p77885;

import java.util.Arrays;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
                continue;
            }
            String b = Long.toString(numbers[i], 2);
            String result = null;
            boolean chk = false;
            for (int j = b.length() - 1; j >= 0; j--) {
                if (b.charAt(j) == '0') {
                    result = b.substring(0, j) + "10" + b.substring(j + 2);
                    chk = true;
                    break;
                }
            }
            if (!chk) {
                result = "10" + b.substring(1);
            }
            answer[i] = Long.parseLong(result, 2);
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = Arrays.toString(solution.solution(new long[]{3, 5, 7, 9})) + "";
        System.out.println(s);
    }
}