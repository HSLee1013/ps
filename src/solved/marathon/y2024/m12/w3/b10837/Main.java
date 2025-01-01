package solved.marathon.y2024.m12.w3.b10837;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int k = Integer.parseInt(bufferedReader.readLine());
        int c = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < c; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int m = Integer.parseInt(stringTokenizer.nextToken());
            int n = Integer.parseInt(stringTokenizer.nextToken());

            if (m > n) {
                if (n + k - m + 2 < m) {
                    stringBuilder.append("0\n");
                    continue;
                }
            } else if (m < n) {
                if (m + k - n + 1 < n) {
                    stringBuilder.append("0\n");
                    continue;
                }
            }
            stringBuilder.append("1\n");
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}
