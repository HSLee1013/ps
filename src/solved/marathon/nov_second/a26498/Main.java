package solved.marathon.nov_second.a26498;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(bufferedReader.readLine());
            int[][] flower = new int[k][k];
            for (int x = 0; x < k; x++) {
                String s = bufferedReader.readLine();
                for (int y = 0; y < k; y++) {
                    flower[x][y] = Character.getNumericValue(s.charAt(y));
                }
            }
            boolean horisontal = true, vertical = true;
            for (int x = 0; x < k; x++) {
                for (int y = 0; y < k / 2; y++) {
                    if (flower[x][y] != flower[x][k - 1 - y]) {
                        vertical = false;
                        x = k;
                        break;
                    }
                }
            }
            for (int y = 0; y < k; y++) {
                for (int x = 0; x < k / 2; x++) {
                    if (flower[x][y] != flower[k - 1 - x][y]) {
                        horisontal = false;
                        y=k;
                        break;
                    }
                }
            }
            if (horisontal && vertical)
                stringBuilder.append("Magnificent\n");
            else if (horisontal)
                stringBuilder.append("Beautiful\n");
            else if (vertical)
                stringBuilder.append("Graceful\n");
            else
                stringBuilder.append("Useless\n");
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}
