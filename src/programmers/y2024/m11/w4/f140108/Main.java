package programmers.y2024.m11.w4.f140108;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution("aabbaba") + "";
        System.out.println(s);
    }
}

class Solution {
    public int solution(String s) {
        int answer = 0;
        char prev = ' ';
        int pc = 0;
        int dc = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == s.length() - 1) {
                answer++;
            } else if (prev == ' ') {
                prev = c;
                pc++;
            } else if (prev == c) {
                pc++;
            } else {
                dc++;
                if (pc == dc) {
                    answer++;
                    pc = 0;
                    dc = 0;
                    prev = ' ';
                }
            }
        }
        return answer;
    }
}