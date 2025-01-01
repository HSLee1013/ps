package solved.marathon.y2025.m1.w1.a31798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());
        if (a == 0) {
            System.out.println(c * c - b);
        } else if (b == 0) {
            System.out.println(c * c - a);
        } else {
            System.out.println((int) Math.sqrt(a + b));
        }
        bufferedReader.close();
    }
}