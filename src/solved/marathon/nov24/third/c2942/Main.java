package solved.marathon.nov24.third.c2942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int r = Integer.parseInt(stringTokenizer.nextToken());
        int g = Integer.parseInt(stringTokenizer.nextToken());
        int gcd = gcd(r, g);
        for (int i = 1; i * i <= gcd; i++) {
            if (gcd % i == 0) {
                stringBuilder.append(String.format("%d %d %d\n", i, r / i, g / i));
                if (gcd / i != i) {
                    stringBuilder.append(String.format("%d %d %d\n", gcd / i, r / gcd * i, g / gcd * i));
                }
            }
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }

    private static int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }
}