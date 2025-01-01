package solved.marathon.y2024.m11.w3.f2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        boolean[][] map = new boolean[n][m];
        int result = 0;
        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) == 'L';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!map[i][j])
                    continue;
                boolean[][] chk = new boolean[n][m];
                chk[i][j] = true;
                Queue<int[]> que = new ArrayDeque<>();
                que.add(new int[]{i, j});
                int dist = -1;
                while (!que.isEmpty()) {
                    int size = que.size();
                    dist++;
                    for (int k = 0; k < size; k++) {
                        int[] cur = que.poll();
                        for (int l = 0; l < dir.length; l++) {
                            int x = cur[0] + dir[l][0];
                            int y = cur[1] + dir[l][1];
                            if (x < 0 || x >= n || y < 0 || y >= m || chk[x][y] || !map[x][y]) continue;
                            chk[x][y] = true;
                            que.add(new int[]{x, y});
                        }
                    }
                }
                result = Math.max(result, dist);
            }
        }
        System.out.println(result);
        bufferedReader.close();
    }
}