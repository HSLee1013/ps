package programmers.y2025.m1.w2.c67258;

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int size = new HashSet<String>(Arrays.asList(gems)).size();
        int l = 0;
        int r = 0;
        int ll = 0;
        int rr = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        map.put(gems[0], 1);
        while (r < gems.length && l <= r) {
            if (r - l + 1 < size || map.size() < size) {
                r++;
                if (r < gems.length)
                    map.put(gems[r], map.getOrDefault(gems[r], 0) + 1);
            } else {
                if (r - l < rr - ll) {
                    rr = r;
                    ll = l;
                }
                map.put(gems[l], map.get(gems[l]) - 1);
                if (map.get(gems[l]) == 0) {
                    map.remove(gems[l]);
                }
                l++;
            }
        }
        return new int[]{ll + 1, rr + 1};
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = Arrays.toString(solution.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})) + "";
        System.out.println(s);
    }
}