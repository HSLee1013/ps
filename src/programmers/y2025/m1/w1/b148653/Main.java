package programmers.y2025.m1.w1.b148653;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        while (storey > 0) {
            int n = storey % 10;
            storey /= 10;
            if (n > 5 || (n == 5 && storey % 10 > 4)) {
                storey++;
                n = 10 - n;
            }
            answer += n;
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(16) + "";
        System.out.println(s);
    }
}