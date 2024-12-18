package programmers.dec24.third.p12979;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int prev = -w;
        int dif;
        for (int i : stations) {
            dif = i - prev - w * 2 - 1;
            prev = i;
            answer += (dif + w * 2) / (w * 2 + 1);
        }
        dif = n + w - prev - w * 2;
        answer += (dif + w * 2) / (w * 2 + 1);
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(11, new int[]{4, 11}, 1) + "";
        System.out.println(s);
    }
}