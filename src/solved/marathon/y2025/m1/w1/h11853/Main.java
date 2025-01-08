package solved.marathon.y2025.m1.w1.h11853;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[] v = new int[n + 1];
        PriorityQueue<Input> pq = new PriorityQueue<>((o1, o2) -> o1.l - o2.l);
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int l = Integer.parseInt(stringTokenizer.nextToken());
            int r = Integer.parseInt(stringTokenizer.nextToken());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            pq.add(new Input(l, r, x));
        }
        while (!pq.isEmpty()) {
            Input cur = pq.poll();
            List<Input> list = new ArrayList<>();
            while (!pq.isEmpty()) {
                Input next = pq.poll();
                if (cur.r < next.l) {
                    pq.add(next);
                    break;
                }
                if (next.l - cur.l + cur.x > next.x) {
                    next.x = next.x + cur.r - next.l + 1;
                    next.l = cur.r + 1;
                    if (next.l <= next.r)
                        list.add(next);
                } else {
                    if (cur.r <= next.r) {
                        cur.r = next.l - 1;
                    } else {
                        list.add(new Input(next.r + 1, cur.r, cur.x + next.r - cur.l + 1));
                        cur.r = next.l - 1;
                    }
                    list.add(next);
                }
            }
            for (int i = cur.l; i <= cur.r; i++) {
                v[i] = cur.x++;
            }
            pq.addAll(list);
        }
        for (int i = 1; i <= n; i++) {
            stringBuilder.append(v[i]).append(' ');
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}

class Input {
    int l;
    int r;
    int x;

    public Input(int l, int r, int x) {
        this.l = l;
        this.r = r;
        this.x = x;
    }
}