package programmers.nov_second.p49994;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution("ULURRDLLU") + "";
        System.out.println(s);
    }
}

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        char[] chars = dirs.toCharArray();
        int[] prev = {0, 0};
        Set<String> set = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        for (char c : chars) {
            int[] cur = prev.clone();
            switch (c) {
                case 'U':
                    cur[1] += 1;
                    break;
                case 'D':
                    cur[1] -= 1;
                    break;
                case 'L':
                    cur[0] -= 1;
                    break;
                case 'R':
                    cur[0] += 1;
                    break;
            }
            if (cur[0] < -5 || cur[0] > 5 || cur[1] < -5 || cur[1] > 5) {
                continue;
            }
            stringBuilder.append(prev[0]).append(prev[1]).append(cur[0]).append(cur[1]);
            stringBuilder2.append(cur[0]).append(cur[1]).append(prev[0]).append(prev[1]);
            if (!set.contains(stringBuilder.toString())) {
                set.add(stringBuilder.toString());
                set.add(stringBuilder2.toString());
                answer++;
            }
            stringBuilder.setLength(0);
            stringBuilder2.setLength(0);
            prev = cur;
        }
        return answer;
    }
}
