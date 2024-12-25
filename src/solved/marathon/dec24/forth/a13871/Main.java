package solved.marathon.dec24.forth.a13871;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());
        int s = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int result = s == 1 ? 1 : 0;
        int rx = 1;
        for (int i = 0; i < c; i++) {
            int x = Integer.parseInt(stringTokenizer.nextToken());
            rx = rx + x;
            if (rx > n) rx = 1;
            if (rx == 0) rx = n;
            if (s == rx) result++;
        }
        System.out.println(result);
        bufferedReader.close();
    }
}