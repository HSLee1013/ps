package programmers.dec24.third.p68936;

import java.util.Arrays;

class Solution {
    private int[][] arr;
    private final int[] result = new int[2];

    public int[] solution(int[][] arr) {
        this.arr = arr;
        solve(0, 0, arr.length);

        return result;
    }

    private int solve(int x, int y, int size) {
        if (size == 1) {
            result[arr[x][y]]++;
            return arr[x][y];
        }
        int a = solve(x, y, size / 2);
        int b = solve(x + size / 2, y, size / 2);
        int c = solve(x, y + size / 2, size / 2);
        int d = solve(x + size / 2, y + size / 2, size / 2);
        if (a != 2 && a == b && b == c && c == d) {
            result[a] -= 3;
            return a;
        }
        return 2;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = Arrays.toString(solution.solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})) + "";
        System.out.println(s);
    }
}