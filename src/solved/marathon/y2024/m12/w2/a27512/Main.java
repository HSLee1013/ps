package solved.marathon.y2024.m12.w2.a27512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int mul = Integer.parseInt(stringTokenizer.nextToken()) * Integer.parseInt(stringTokenizer.nextToken());
        System.out.println(mul % 2 == 0 ? mul : mul - 1);
        bufferedReader.close();
    }
}