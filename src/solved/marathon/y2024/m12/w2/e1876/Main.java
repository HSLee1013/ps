package solved.marathon.y2024.m12.w2.e1876;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            double t = Double.parseDouble(stringTokenizer.nextToken());
            double x = Double.parseDouble(stringTokenizer.nextToken());
            double min = t * 100 - (16 / Math.sin(Math.toRadians(x)));
            double max = t * 100 + (16 / Math.sin(Math.toRadians(x)));
            double move = 85 / Math.tan(Math.toRadians(x));

            boolean hit = false;
            double total = 0;
            while (max > total) {
                if (total > min) {
                    hit = true;
                    break;
                }
                total += move;
            }
            stringBuilder.append(hit ? "yes" : "no").append("\n");
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}
