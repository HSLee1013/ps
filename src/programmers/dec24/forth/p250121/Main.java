package programmers.dec24.forth.p250121;

import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>() {{
            put("code", 0);
            put("date", 1);
            put("maximum", 2);
            put("remain", 3);
        }};
        for (int i = 0; i < data.length; i++) {
            if (data[i][map.get(ext)] < val_ext) {
                list.add(data[i]);
            }
        }
        list.sort((o1, o2) -> o1[map.get(sort_by)] - o2[map.get(sort_by)]);

        return list.toArray(new int[list.size()][]);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = Arrays.deepToString(solution.solution(new int[][]{{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}}, "date", 20300501, "remain")) + "";
        System.out.println(s);
    }
}