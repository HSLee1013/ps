package solved.marathon.nov24.forth.e25993;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] map = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            map[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            map[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }
        double result = 0;
        for (int i = 1; i < n - 1; i++) {
            double left = (double) map[i][1] / (map[i][0] - map[0][0]);
            double right = (double) map[i][1] / (map[n - 1][0] - map[i][0]);
            result = Math.max(Math.max(result, left), right);
        }
        System.out.println(Math.atan(result) * 180 / Math.PI);
        bufferedReader.close();
    }
}