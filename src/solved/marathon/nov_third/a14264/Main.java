package solved.marathon.nov_third.a14264;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        System.out.println(Math.pow(n, 2) / 4 * Math.sqrt(3));
        bufferedReader.close();
    }
}