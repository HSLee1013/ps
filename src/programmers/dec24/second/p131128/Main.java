package programmers.dec24.second.p131128;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] num1 = new int[10];
        int[] num2 = new int[10];
        int[] result = new int[10];
        for (char c : X.toCharArray()) {
            num1[c - '0']++;
        }
        for (char c : Y.toCharArray()) {
            num2[c - '0']++;
        }
        for (int i = 0; i < 10; i++) {
            result[i] = Math.min(num1[i], num2[i]);
        }
        boolean chk = false;
        for (int i = 9; i >= 0; i--) {
            if (result[i] > 0)
                chk = true;
            if (i == 0 && stringBuilder.length()==0) {
                stringBuilder.append(0);
                break;
            }
            for (int j = 0; j < result[i]; j++) {
                stringBuilder.append(i);
            }
        }
        return chk ? stringBuilder.toString() : "-1";
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution("100", "2345") + "";
        System.out.println(s);
    }
}