package solved.marathon.dec24.forth.b6012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        System.out.println(solve(1, n));
        bufferedReader.close();
    }

    private static int solve(int a, int b) {
        if (b - a == 1)
            return a * b;
        if (a == b)
            return 0;
        return solve(a, (a + b) / 2) + solve((a + b) / 2 + 1, b);
    }
}