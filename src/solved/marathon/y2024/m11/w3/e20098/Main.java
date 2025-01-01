package solved.marathon.y2024.m11.w3.e20098;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/solved/marathon/nov_third/e20098/05.in");
        File outputFile = new File("src/solved/marathon/nov_third/e20098/05.out");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
        String line;
        n = Integer.parseInt(bufferedReader.readLine());
        map = new int[n * n][n * n];
        for (int i = 0; i < n * n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n * n; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                fillMap(i, j);
            }
        }
        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < n * n; j++) {
                bufferedWriter.write(map[i][j] + " ");
            }
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void fillMap(int x, int y) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int si = y * n;
                int sj = (x * n + y * n) % (n * n);
                int cur = (i * n + j + 1 + x * n - 1) % (n * n) + 1;
                map[si + i][sj + (j + x) % n] = cur;
            }
        }
    }
}