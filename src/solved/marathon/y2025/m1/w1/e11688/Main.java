package solved.marathon.y2025.m1.w1.e11688;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long a = Long.parseLong(stringTokenizer.nextToken());
        long b = Long.parseLong(stringTokenizer.nextToken());
        long l = Long.parseLong(stringTokenizer.nextToken());
        long ab = a * b / gcd(a, b);
        long result = -1;
        if (l == ab) {
            result = 1;
        } else if (l % ab == 0) {
            long inc = l / ab;
            for (long i = inc; i <= l; i += inc) {
                if (l % i != 0) continue;
                long gcd = gcd(ab, i);
                if (ab * i / gcd == l) {
                    result = i;
                    break;
                }
            }
        }
        System.out.println(result);
        bufferedReader.close();
    }

    private static long gcd(long a, long b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}