package solved.marathon.dec24.first.b17484;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[][][] map = new int[n][m][4];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j][0] = Integer.parseInt(stringTokenizer.nextToken());
                if (i == 0) {
                    for (int k = 1; k < 4; k++) {
                        map[i][j][k] = map[i][j][0];
                    }
                    continue;
                }
                if (j - 1 < 0)
                    map[i][j][1] = Integer.MAX_VALUE;
                else
                    map[i][j][1] = map[i][j][0] + Math.min(map[i - 1][j - 1][2], map[i - 1][j - 1][3]);
                map[i][j][2] = map[i][j][0] + Math.min(map[i - 1][j][1], map[i - 1][j][3]);
                if (j + 1 >= m)
                    map[i][j][3] = Integer.MAX_VALUE;
                else
                    map[i][j][3] = map[i][j][0] + Math.min(map[i - 1][j + 1][1], map[i - 1][j + 1][2]);
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < 4; j++) {
                result = Math.min(result, map[n - 1][i][j]);
            }
        }
        System.out.println(result);
        bufferedReader.close();
    }
}