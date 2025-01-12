package programmers.y2025.m1.w2.e159993;

import java.util.*;

class Solution {
    boolean[][] map;
    final int dir[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int solution(String[] maps) {
        map = new boolean[maps.length][maps[0].length()];
        int[] s = null;
        int[] e = null;
        int[] l = null;
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                char c = maps[i].charAt(j);
                if (c == 'X') continue;
                map[i][j] = true;
                if (c == 'S') {
                    s = new int[]{i, j};
                } else if (c == 'E') {
                    e = new int[]{i, j};
                } else if (c == 'L') {
                    l = new int[]{i, j};
                }
            }
        }
        int sl = bfs(s, l);
        if (sl == -1) return -1;
        int le = bfs(l, e);
        if (le == -1) return -1;
        return sl + le;
    }

    public int bfs(int[] start, int[] end) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(start);
        visited[start[0]][start[1]] = true;
        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            dist++;
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int j = 0; j < dir.length; j++) {
                    int nx = cur[0] + dir[j][0];
                    int ny = cur[1] + dir[j][1];
                    if (nx == end[0] && ny == end[1]) {
                        return dist;
                    }
                    if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length || visited[nx][ny] || !map[nx][ny])
                        continue;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }

        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"}) + "";
        System.out.println(s);
    }
}