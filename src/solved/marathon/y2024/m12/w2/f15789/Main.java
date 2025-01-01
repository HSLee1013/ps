package solved.marathon.y2024.m12.w2.f15789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int y = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            list.get(x).add(y);
            list.get(y).add(x);
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int c = Integer.parseInt(stringTokenizer.nextToken()) - 1;
        int h = Integer.parseInt(stringTokenizer.nextToken()) - 1;
        int k = Integer.parseInt(stringTokenizer.nextToken());
        int result = 1;
        PriorityQueue<Integer> powerQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            int chk = 0;
            int power = 0;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                power++;
                if (cur == c)
                    chk = 1;
                if (cur == h)
                    chk = 2;
                for (int j : list.get(cur)) {
                    if (visited[j]) continue;
                    visited[j] = true;
                    queue.add(j);
                }
            }
            if (chk == 0)
                powerQueue.add(power);
            if (chk == 1)
                result = power;
        }
        for (int i = 0; i < k && !powerQueue.isEmpty(); i++) {
            result += powerQueue.poll();
        }
        System.out.println(result);
        bufferedReader.close();
    }
}
