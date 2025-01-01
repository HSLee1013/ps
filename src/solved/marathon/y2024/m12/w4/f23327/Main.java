package solved.marathon.y2024.m12.w4.f23327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int q = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] a = new int[n + 1];
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(stringTokenizer.nextToken());
            sum[i] = sum[i - 1] + a[i];
        }
        long[] mul = new long[n + 1];
        for (int i = 2; i <= n; i++) {
            mul[i] = mul[i - 1] + a[i] * sum[i - 1];
        }
        for (int i = 0; i < q; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int l = Integer.parseInt(stringTokenizer.nextToken());
            int r = Integer.parseInt(stringTokenizer.nextToken());
            stringBuilder.append(mul[r] - mul[l] - (sum[l - 1] * (sum[r] - sum[l]))).append('\n');
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}