package solved.marathon.dec24.first.a26550;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            long n = Integer.parseInt(bufferedReader.readLine());
            stringBuilder.append(n * (n + 1) * (n + 2) / 6).append('\n');
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}