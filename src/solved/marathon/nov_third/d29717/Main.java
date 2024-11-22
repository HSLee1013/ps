package solved.marathon.nov_third.d29717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            long n = Long.parseLong(bufferedReader.readLine());
            long exp = n * (n + 1) / 2;
            long s = 1, e = 1000000000;
            while (s < e) {
                long m = (s + e) / 2;
                long nexp = m * (m + 1);
                if (nexp <= exp) {
                    s = m + 1;
                } else {
                    e = m - 1;
                }
            }
            stringBuilder.append(s).append('\n');
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}