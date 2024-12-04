package programmers.nov24.forth.p77484;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = Arrays.toString(solution.solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})) + "";
        System.out.println(s);
    }
}

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : win_nums) {
            set.add(i);
        }
        int same = 0;
        int diff = 0;
        for (int i : lottos) {
            if (i == 0) continue;
            if (set.contains(i)) same++;
            else diff++;
        }
        return new int[]{Math.min(1 + diff, 6), Math.min(6, 7 - same)};
    }
}