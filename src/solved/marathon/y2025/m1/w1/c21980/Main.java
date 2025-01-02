package solved.marathon.y2025.m1.w1.c21980;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            String[] x = bufferedReader.readLine().split(" ");
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int count = 0;
                char[] cs = x[j].toCharArray();
                for (int l = 0; l < k; l++) {
                    if (cs[l] < 'a') {
                        count++;
                        cs[l] += 32;
                    }
                }
                Arrays.sort(cs);
                String s = String.valueOf(cs) + count;
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
            int result = 0;
            for (int j : map.values()) {
                if (j == 1) continue;
                result += j * (j - 1) / 2;
            }
            stringBuilder.append(result).append('\n');
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}