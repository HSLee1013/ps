package solved.marathon.y2024.m11.w3.h9489;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while (!(line = bufferedReader.readLine()).startsWith("0")) {
            StringTokenizer stringTokenizer = new StringTokenizer(line);
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            int[] c = new int[n + 1];
            int[] p = new int[n + 1];
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            p[0] = -1;
            c[0] = -1;
            int index = -1;
            int kk = 0;
            for (int i = 1; i <= n; i++) {
                c[i] = Integer.parseInt(stringTokenizer.nextToken());
                if (c[i] != c[i - 1] + 1) index++;
                if (c[i] == k) kk = i;
                p[i] = index;
            }
            int result = 0;
            for (int i = 1; i <= n; i++) {
                if (p[p[i]] != p[p[kk]])
                    continue;
                if (p[i] == p[kk])
                    continue;
                result++;
            }
            stringBuilder.append(result).append('\n');
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}