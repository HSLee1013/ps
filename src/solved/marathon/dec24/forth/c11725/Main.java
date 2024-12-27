package solved.marathon.dec24.forth.c11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] result = new int[n + 1];
        List<Integer>[] list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0; i < list[cur].size(); i++) {
                if (visited[list[cur].get(i)]) continue;
                result[list[cur].get(i)] = cur;
                visited[list[cur].get(i)] = true;
                queue.add(list[cur].get(i));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            stringBuilder.append(result[i]).append('\n');
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}