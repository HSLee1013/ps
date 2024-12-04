package programmers.nov24.forth.p42898;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(4, 3, new int[][]{{2, 2}}) + "";
        System.out.println(s);
    }
}

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] map = new boolean[n + 1][m + 1];
        int[][] dist = new int[n + 1][m + 1];
        for (int[] puddle : puddles) {
            map[puddle[1]][puddle[0]] = true;
        }
        dist[0][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j]) continue;
                dist[i][j] = dist[i - 1][j] + dist[i][j - 1];
                dist[i][j] %= 1000000007;
            }
        }
        return dist[n][m];
    }
}