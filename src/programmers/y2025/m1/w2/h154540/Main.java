package programmers.y2025.m1.w2.h154540;

import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (visited[i][j]) continue;
                visited[i][j] = true;
                if (maps[i].charAt(j) == 'X') continue;
                queue.add(new int[]{i, j});
                int count = Character.getNumericValue(maps[i].charAt(j));
                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    for (int k = 0; k < dir.length; k++) {
                        int nx = cur[0] + dir[k][0];
                        int ny = cur[1] + dir[k][1];
                        if (nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[nx].length() || visited[nx][ny])
                            continue;
                        visited[nx][ny] = true;
                        if (maps[nx].charAt(ny) == 'X') continue;
                        count += Character.getNumericValue(maps[nx].charAt(ny));
                        queue.add(new int[]{nx, ny});
                    }
                }
                list.add(count);
            }
        }
        if (list.size() == 0) return new int[]{-1};
        return list.stream().mapToInt(i -> i).sorted().toArray();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = Arrays.toString(solution.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"})) + "";
        System.out.println(s);
    }
}