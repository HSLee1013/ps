package programmers.nov24.forth.p92341;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = Arrays.toString(solution.solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})) + "";
        System.out.println(s);
    }
}

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> time = new HashMap<>();
        Map<String, Integer> alltime = new TreeMap<>();
        for (String record : records) {
            String[] split = record.split(" ");
            String[] split2 = split[0].split(":");
            int t = Integer.parseInt(split2[0]) * 60 + Integer.parseInt(split2[1]);
            if (split[2].length() == 2) {
                time.put(split[1], t);
            } else {
                alltime.put(split[1], alltime.getOrDefault(split[1], 0) + t - time.get(split[1]));
                time.remove(split[1]);
            }
        }
        for (Map.Entry<String, Integer> entry : time.entrySet()) {
            alltime.put(entry.getKey(), alltime.getOrDefault(entry.getKey(), 0) + 1439 - entry.getValue());
        }
        int[] answer = new int[alltime.size()];
        int i = 0;
        for (int t : alltime.values()) {
            int it = Math.max(0, (t - fees[0] + fees[2] - 1) / fees[2]);
            answer[i] = fees[1] + it * fees[3];
            i++;
        }
        return answer;
    }
}