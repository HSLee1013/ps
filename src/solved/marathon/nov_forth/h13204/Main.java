package solved.marathon.nov_forth.h13204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            double d = Double.parseDouble(bufferedReader.readLine());
            int n = 1;
            while (true) {
                int k = (int) Math.round(d * n / 100);
                double p = Math.round(100000.0 * k / n) / 1000.0;
                if (p == d) {
                    stringBuilder.append(n).append('\n');
                    break;
                }
                n++;
            }
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}