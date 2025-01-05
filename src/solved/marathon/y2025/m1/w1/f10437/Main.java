package solved.marathon.y2025.m1.w1.f10437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int p = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < p; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            if (y > x) {
                stringBuilder.append(n).append(" 2 ").append(x).append(" ").append(y).append('\n');
            } else {
                if (y < 4) {
                    stringBuilder.append(n).append(" NO PATH\n");
                } else {
                    stringBuilder.append(n).append(" 6 1 2 3 ").append(x - y + 5).append(" ").append(x + 2).append(" ").append(x + 3).append('\n');
                }
            }
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}