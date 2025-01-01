package programmers.y2024.m12.w4.b42883;

class Solution {
    public String solution(String number, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] stack = new char[number.length()];
        int si = -1;
        int ni = 0;
        for (int i = 0; i < k; i++) {
            if (si == -1) {
                stack[++si] = number.charAt(ni++);
            }
            while (ni < number.length() && stack[si] >= number.charAt(ni)) {
                stack[++si] = number.charAt(ni++);
            }
            si--;
        }
        for (int i = 0; i <= si; i++) {
            stringBuilder.append(stack[i]);
        }
        stringBuilder.append(number.substring(ni));
        return stringBuilder.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution("999", 2) + "";
        System.out.println(s);
    }
}