package solved.marathon.dec24.third.d24057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        long[] a = new long[4];
        long[] b = new long[4];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 4; i++) {
            a[i] = Long.parseLong(stringTokenizer.nextToken());
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 4; i++) {
            b[i] = Long.parseLong(stringTokenizer.nextToken());
        }
        long[][] result = new long[4][4];
        result[0][0] = a[0] * b[0];
        result[0][3] = a[3];
        result[1][0] = result[0][0];
        result[1][3] = result[0][3];
        for (int i = 1; i < 3; i++) {
            result[0][i] = a[i] * b[0] + b[i] * a[0];
            result[1][i] = a[i] * b[0] - b[i] * a[0];
        }

        result[2][0] = a[0] * b[0];
        long[] mul = multiple(a[1], a[2], a[3], b[1], b[2]);
        result[2][1] = mul[0];
        result[2][2] = mul[1];
        result[2][3] = a[3];

        result[3][3] = result[0][3];
        long[] divU = multiple(a[1], a[2], a[3], b[0], 0);
        long[] divD = multiple(b[1], b[2], a[3], a[0], 0);
        long[] divU2 = multiple(divU[0], divU[1], a[3], divD[0], -divD[1]);
        long[] divD2 = multiple(divD[0], divD[1], a[3], divD[0], -divD[1]);
        result[3][0] = divD2[0];
        result[3][1] = divU2[0];
        result[3][2] = divU2[1];
        for (int i = 0; i < 4; i++) {
            gcd(result[i]);
            for (int j = 0; j < 4; j++) {
                stringBuilder.append(result[i][j]).append(' ');
            }
            stringBuilder.append('\n');
        }
        System.out.println(stringBuilder);
        bufferedReader.close();
    }

    private static void gcd(long[] arr) {
        long gcd = gcd(arr[0], arr[1], arr[2]);
        boolean chk = arr[0] < 0;
        for (int i = 0; i < 3; i++) {
            arr[i] = arr[i] / gcd * (chk ? -1 : 1);
        }
        if (arr[2] == 0)
            arr[3] = 0;
    }

    private static long[] multiple(long a1, long a2, long a3, long b1, long b2) {
        return new long[]{a1 * b1 + a2 * b2 * a3, a1 * b2 + b1 * a2};
    }

    private static long gcd(long a, long b, long c) {
        long gcd = gcd(a, b);
        return Math.abs(gcd(gcd, c));
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}
