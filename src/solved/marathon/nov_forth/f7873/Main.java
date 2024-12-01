package solved.marathon.nov_forth.f7873;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static char[][] map;
    static boolean[][] visited;
    static int result;
    static Map<Character, char[]> dirc = new HashMap<>();
    static Map<Character, int[]> diri = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int z = Integer.parseInt(bufferedReader.readLine());
        dirc.put('B', new char[]{'L', 'D'});
        dirc.put('C', new char[]{'L', 'U'});
        dirc.put('D', new char[]{'R', 'U'});
        dirc.put('E', new char[]{'R', 'D'});
        dirc.put('F', new char[]{'L', 'R', 'U', 'D'});
        diri.put('L', new int[]{0, -1});
        diri.put('R', new int[]{0, 1});
        diri.put('U', new int[]{-1, 0});
        diri.put('D', new int[]{1, 0});
        for (int i = 0; i < z; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            n = Integer.parseInt(stringTokenizer.nextToken());
            m = Integer.parseInt(stringTokenizer.nextToken());
            map = new char[n][];
            visited = new boolean[n][m];
            result = 0;
            for (int j = 0; j < n; j++) {
                String line = bufferedReader.readLine();
                map[j] = line.toCharArray();
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (visited[j][k]) continue;
                    visited[j][k] = true;
                    if (map[j][k] == 'A') continue;
                    bfs(j, k);
                }
            }
            stringBuilder.append(result).append('\n');
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }

    private static void bfs(int j, int k) {
        result++;
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{j, k});
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            char c = map[cur[0]][cur[1]];
            for (Character dc : dirc.get(c)) {
                int x = cur[0] + diri.get(dc)[0];
                int y = cur[1] + diri.get(dc)[1];
                if (x < 0 || y < 0 || x >= n || y >= m) continue;
                if (visited[x][y]) continue;
                char nc = map[x][y];
                if (nc == 'A') continue;
                if (dc == 'L')
                    if (nc == 'B' || nc == 'C') continue;
                if (dc == 'R')
                    if (nc == 'D' || nc == 'E') continue;
                if (dc == 'U')
                    if (nc == 'C' || nc == 'D') continue;
                if (dc == 'D')
                    if (nc == 'B' || nc == 'E') continue;
                visited[x][y] = true;
                que.add(new int[]{x, y});
            }
        }
    }
}