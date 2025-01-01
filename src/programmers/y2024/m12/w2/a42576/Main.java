package programmers.y2024.m12.w2.a42576;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(new String[]{}, new String[]{}) + "";
        System.out.println(s);
    }
}

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : completion) {
            int count = map.get(s) - 1;
            if (count == 0)
                map.remove(s);
            else
                map.put(s, count);
        }
        return map.keySet().iterator().next();
    }
}