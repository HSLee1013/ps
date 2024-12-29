package solved.marathon.dec24.forth.e26217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        double result = 0;
        for (double i = 0; i < n; i++) {
            result += n / (n - i);
        }
        System.out.println(result);
        bufferedReader.close();
    }
}