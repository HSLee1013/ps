package programmers.p340202;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(5141, 500, new int[]{10, -10, 10, -10, 10, -10, 10, -10, 10, -10}) + "";
        System.out.println(s);
    }
}

class Solution {
    public int solution(int storage, int usage, int[] change) {
        int total_usage = 0;
        for (int i = 0; i < change.length; i++) {
            usage = usage * (100 + change[i]) / 100; // 수정된 줄
            total_usage += usage;
            if (total_usage > storage) {
                return i;
            }
        }
        return -1;
    }
}
