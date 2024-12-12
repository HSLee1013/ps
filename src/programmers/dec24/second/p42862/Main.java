package programmers.dec24.second.p42862;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(5, new int[]{1, 2, 4, 5}, new int[]{2, 3, 4}) + "";
        System.out.println(s);
    }
}

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        for (int l : lost) {
            lostSet.add(l);
        }
        for (int r : reserve) {
            if (lostSet.contains(r)) {
                lostSet.remove(r);
            } else {
                reserveSet.add(r);
            }
        }
        int count = 0;
        for (int l : lostSet) {
            if (reserveSet.contains(l - 1)) {
                reserveSet.remove(l - 1);
                count++;
            } else if (reserveSet.contains(l + 1)) {
                reserveSet.remove(l + 1);
                count++;
            }
        }
        return n - lostSet.size() + count;
    }
}