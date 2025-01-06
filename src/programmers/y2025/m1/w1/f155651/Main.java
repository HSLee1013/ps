package programmers.y2025.m1.w1.f155651;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] time = new int[1440];
        for (String[] strings : book_time) {
            int start = time(strings[0]);
            int end = Math.min(time(strings[1]) + 10,1440);
            for (int i = start; i < end; i++) {
                time[i]++;
            }
        }
        for (int i = 0; i < 1440; i++) {
            answer = Math.max(answer, time[i]);
        }
        return answer;
    }

    private int time(String s) {
        String[] split = s.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        return hour * 60 + minute;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "23:59"}}) + "";
        System.out.println(s);
    }
}