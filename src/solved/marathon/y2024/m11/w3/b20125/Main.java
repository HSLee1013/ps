package solved.marathon.y2024.m11.w3.b20125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        boolean head = false;
        int lh = 0, rh = 0, b = 0, ll = 0, rl = 0;
        int[] heart = new int[2];
        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < n; j++) {
                if (line.charAt(j) != '*')
                    continue;
                if (!head) {
                    head = true;
                    heart[0] = i + 1;
                    heart[1] = j;
                    continue;
                }
                if (i == heart[0] && j < heart[1]) {
                    lh++;
                } else if (i == heart[0] && j > heart[1]) {
                    rh++;
                } else if (i > heart[0] && j == heart[1]) {
                    b++;
                } else if (i > heart[0] && j == heart[1] - 1) {
                    ll++;
                } else if (i > heart[0] && j == heart[1] + 1) {
                    rl++;
                }
            }
        }
        System.out.printf("%d %d\n%d %d %d %d %d\n", heart[0] + 1, heart[1] + 1, lh, rh, b, ll, rl);
        bufferedReader.close();
    }
}