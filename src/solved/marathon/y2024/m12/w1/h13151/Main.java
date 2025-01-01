package solved.marathon.y2024.m12.w1.h13151;

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
        int l = Integer.parseInt(stringTokenizer.nextToken());

        List<Map<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new HashMap<>());
        }
        int totalLength = 0;
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int b = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int c = Integer.parseInt(stringTokenizer.nextToken());
            if (i < l)
                totalLength += c;
            int min = Math.min(c, list.get(a).getOrDefault(b, Integer.MAX_VALUE));
            list.get(a).put(b, min);
            list.get(b).put(a, min);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        pq.add(new AbstractMap.SimpleEntry<>(0, 0));

        boolean[] chk = new boolean[n];
        int count = 0;
        int sum = 0;
        while (!pq.isEmpty() && count < n) {
            Map.Entry<Integer, Integer> cur = pq.poll();
            if (chk[cur.getKey()]) continue;
            chk[cur.getKey()] = true;
            count++;
            sum += cur.getValue();

            for (Map.Entry<Integer, Integer> entry : list.get(cur.getKey()).entrySet()) {
                if (chk[entry.getKey()])
                    continue;
                pq.add(new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue()));
            }
        }

        if (sum <= totalLength && count == n) {
            System.out.println("possible");
        } else {
            System.out.println("impossible");
        }
        bufferedReader.close();
    }
}