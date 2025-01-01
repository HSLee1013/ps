package solved.marathon.y2024.m12.w1.g1687;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[][] arr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String s = bufferedReader.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = arr[i][j - 1] + ('1' - s.charAt(j - 1));
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] += arr[i - 1][j];
            }
        }
        int result = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                int size = 0;
                for (int k = 1; k <= n; k++) {
                    int part = arr[k][j] - arr[k][i - 1] - arr[k - 1][j] + arr[k - 1][i - 1];
                    if (part == j - i + 1) {
                        size += part;
                        result = Math.max(result, size);
                    } else {
                        size = 0;
                    }
                }
            }
        }
        System.out.println(result);
        bufferedReader.close();
    }
}