package solved.marathon.y2025.m1.w1.d24649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        boolean[][] grid = new boolean[n][m];
        int[][] dirF = {{0, 0}, {0, 1}, {0, 2}, {1, 0}, {2, 0}, {2, 1}, {3, 0}, {4, 0}};
        int[][] dirQ = {{0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {3, 2}, {4, 2}};
        int f = 0;
        int q = 0;
        for (int i = 0; i < n; i++) {
            String s = bufferedReader.readLine();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == '.') continue;
                grid[i][j] = true;
            }
        }
        for (int j = 0; j < m - 2; j++) {
            for (int i = 0; i < n - 4; i++) {
                if (!grid[i][j]) continue;
                if (grid[i + 3][j]) {
                    for (int[] dir : dirF) {
                        grid[i + dir[0]][j + dir[1]] = false;
                    }
                    f++;
                } else {
                    for (int[] dir : dirQ) {
                        grid[i + dir[0]][j + dir[1]] = false;
                    }
                    q++;
                }
            }
        }

        System.out.println(q + " " + f);
        bufferedReader.close();
    }
}