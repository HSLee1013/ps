package solved.marathon.y2025.m1.w1.g24025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int s = 1;
        int e = n;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(stringTokenizer.nextToken());
            if (i == n - 1 && a < 0) {
                stringBuilder = new StringBuilder("-1");
                break;
            }
            if (a > 0) {
                stringBuilder.append(e--).append(" ");
            } else {
                stringBuilder.append(s++).append(" ");
            }
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}