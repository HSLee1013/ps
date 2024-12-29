package solved.marathon.dec24.forth.d12567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int t = Integer.parseInt(bufferedReader.readLine());
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, 1}, {1, -1}};

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            boolean[][] v = new boolean[102][102];
            boolean[][] map = new boolean[102][102];
            List<int[]> list = new ArrayList<>();
            Queue<int[]> queue = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int x1 = Integer.parseInt(stringTokenizer.nextToken());
                int y1 = Integer.parseInt(stringTokenizer.nextToken());
                int x2 = Integer.parseInt(stringTokenizer.nextToken());
                int y2 = Integer.parseInt(stringTokenizer.nextToken());
                for (int x = x1; x <= x2; x++) {
                    for (int y = y1; y <= y2; y++) {
                        map[x][y] = true;
                        list.add(new int[]{x, y});
                    }
                }
            }
            int result = 0;
            for (int[] cur : list) {
                if (v[cur[0]][cur[1]]) continue;
                v[cur[0]][cur[1]] = true;
                int maxX = 0;
                int maxY = 0;
                int minXY = Integer.MAX_VALUE;
                queue.add(cur);
                while (!queue.isEmpty()) {
                    cur = queue.poll();
                    maxX = Math.max(maxX, cur[0]);
                    maxY = Math.max(maxY, cur[1]);
                    minXY = Math.min(minXY, cur[0] + cur[1]);
                    for (int[] d : dir) {
                        int[] next = {cur[0] + d[0], cur[1] + d[1]};
                        if (v[next[0]][next[1]]) continue;
                        v[next[0]][next[1]] = true;
                        if (!map[next[0]][next[1]]) continue;
                        queue.add(next);
                    }
                }
                result = Math.max(result, maxX + maxY - minXY + 1);
            }
            stringBuilder.append("Case #").append(i + 1).append(": ").append(result).append('\n');
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}