package solved.marathon.dec24.forth.h27499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        Map<Double, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            for (int j = 0; j < k; j++) {
                double kx = j % 2 == 0 ? m * j + x : (j + 1) * m - x;
                int count = map.getOrDefault(y / kx, 0) + 1;
                map.put(y / kx, count);
                result = Math.max(result, count);
            }
        }
        System.out.println(result);
        bufferedReader.close();
    }
}