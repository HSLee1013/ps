package solved.marathon.y2025.m1.w1.b3699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int h = Integer.parseInt(stringTokenizer.nextToken());
            int l = Integer.parseInt(stringTokenizer.nextToken());
            int result = 0;
            for (int j = 0; j < h; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                Map<Integer, Integer> map = new TreeMap<>();
                for (int k = 0; k < l; k++) {
                    int a = Integer.parseInt(stringTokenizer.nextToken());
                    if (a == -1)
                        continue;
                    result += 20 * j;
                    map.put(a, k);
                }
                int prev = 0;
                for (int a : map.values()) {
                    result += 5 * Math.min(Math.abs(a - prev), l - Math.abs(a - prev));
                    prev = a;
                }
            }
            stringBuilder.append(result).append('\n');
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}