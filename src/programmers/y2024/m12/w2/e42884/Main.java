package programmers.y2024.m12.w2.e42884;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, Comparator.comparingInt(i -> i[1]));
        int cam = routes[0][1];
        for (int i = 1; i < routes.length; i++) {
            if (routes[i][1] < cam || cam < routes[i][0]) {
                cam = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(new int[][]{{-100, 100}, {50, 170}, {150, 200}, {-50, -10}, {10, 20}, {30, 40}}) + "";
        System.out.println(s);
    }
}