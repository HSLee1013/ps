package solved.marathon.dec24.second.d18066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long[][] n = new long[2][3];
        for (int i = 0; i < 2; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 3; j++) {
                n[i][j] = Long.parseLong(stringTokenizer.nextToken());
            }
        }
        Arrays.sort(n, Comparator.comparingLong(a -> a[2]));
        long[] result = new long[2];
        for (int i = 0; i < 2; i++) {
            long dif = Math.abs(n[1][i] - n[0][i]);
            if (dif <= n[0][2]) {
                result[i] = n[1][i];
                n[0][2] -= dif;
            } else {
                if (n[1][i] > n[0][i]) {
                    result[i] = n[0][i] + n[0][2];
                } else {
                    result[i] = n[0][i] - n[0][2];
                }
                n[0][2] = 0;
            }
        }
        for (int i = 0; i < 2; i++) {
            n[1][2] -= Math.abs(result[i] - n[1][i]);
        }
        if (n[1][2] < 0 || n[0][2] % 2 != n[1][2] % 2) {
            System.out.println("impossible");
        } else {
            if (n[0][2] % 2 == 1)
                System.out.println(result[0] + " " + (result[1] + 1));
            else
                System.out.println(result[0] + " " + result[1]);
        }
        bufferedReader.close();
    }
}
