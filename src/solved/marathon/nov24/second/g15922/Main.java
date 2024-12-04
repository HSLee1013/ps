package solved.marathon.nov24.second.g15922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int max = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            if (x > max) {
                max = y;
                result += y - x;
            } else {
                if (y <= max) {
                    continue;
                }
                result += y - max;
                max = y;
            }
        }
        System.out.println(result);
        bufferedReader.close();
    }
}