package solved.marathon.y2024.m11.w2.c3071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            String s = Integer.toString(n, 3);
            if (n < 0) s = s.substring(1);
            int[] three = new int[s.length() + 1];
            for (int j = s.length() - 1; j >= 0; j--) {
                three[j + 1] = three[j + 1] + Character.getNumericValue(s.charAt(j));
                if (three[j + 1] > 1) {
                    if (three[j + 1] > 2)
                        three[j + 1] = 0;
                    else
                        three[j + 1] = -1;
                    three[j] = 1;
                }
            }
            for (int j = three[0] != 0 ? 0 : 1; j < three.length; j++) {
                int val = three[j];
                if (val == 1) {
                    stringBuilder.append(n < 0 ? "-" : "1");
                } else if (val == -1) {
                    stringBuilder.append(n < 0 ? "1" : "-");
                } else {
                    stringBuilder.append(val);
                }
            }
            stringBuilder.append('\n');
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}
