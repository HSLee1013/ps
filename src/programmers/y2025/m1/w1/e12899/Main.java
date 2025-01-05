package programmers.y2025.m1.w1.e12899;

class Solution {
    public String solution(int n) {
        String answer = Integer.toString(n, 3);
        while (answer.contains("0")) {
            answer = answer.replace("10", "04").replace("20", "14").replace("40", "24");
            if (answer.startsWith("0"))
                answer = answer.substring(1);
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(3) + "";
        System.out.println(s);
    }
}