package programmers.y2025.m1.w2.d72411;

import java.util.*;

class Solution {
    Map<String, Integer> map;
    char[] charArray;
    int count;
    int max;
    int length;
    StringBuilder stringBuilder = new StringBuilder();

    public String[] solution(String[] orders, int[] course) {
        Set<String> answer = new TreeSet<>();

        for (int i : course) {
            map = new HashMap<>();
            max = 0;
            length = i;
            for (String order : orders) {
                count = 0;
                charArray = order.toCharArray();
                Arrays.sort(charArray);
                addMap(0);
            }
            if (max < 2) continue;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == max) {
                    answer.add(entry.getKey());
                }
            }
        }
        return answer.toArray(new String[0]);
    }

    public void addMap(int n) {
        for (int i = n; i < charArray.length; i++) {
            stringBuilder.append(charArray[i]);
            count++;
            if (count < length) {
                addMap(i + 1);
            } else {
                int value = map.getOrDefault(stringBuilder.toString(), 0) + 1;
                map.put(stringBuilder.toString(), value);
                max = Math.max(max, value);
            }
            count--;
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = Arrays.toString(solution.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})) + "";
        System.out.println(s);
    }
}