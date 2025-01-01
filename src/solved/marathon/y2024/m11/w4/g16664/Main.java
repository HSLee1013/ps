package solved.marathon.y2024.m11.w4.g16664;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());
        if (n >= 15) {
            List<String> list = new ArrayList<>(
                    Arrays.asList(
                            "a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1",
                            "h2", "g2", "f2", "e2", "d2", "c2", "b2", "a2",
                            "a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3",
                            "h4", "g4", "f4", "e4", "d4", "c4", "b4", "a4",
                            "a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5",
                            "h6", "g6", "f6", "e6", "d6", "c6", "b6", "a6",
                            "a7", "h7", "g7", "f7", "e7", "d7", "c7", "b7",
                            "b8", "a8", "c8", "d8", "e8", "f8", "g8", "h8"
                    )
            );
            int a = 62;
            int index = 1;

            for (int i = 0; i < 8; i++) {
                for (int j = a; j >= n && j >= a - 5; j--) {
                    list.remove(index);
                }
                a -= 6;
                index = index + 2;
            }
            for(String s: list) {
                stringBuilder.append(s+" ");
            }
        } else {
            stringBuilder.append("a1 ");
            for (int i = 3; i <= n && i < 9; i++) {
                char c = (char) ('a' + i - 2);
                stringBuilder.append(c + "1 ");
            }
            stringBuilder.append("h1 ");
            if (9 <= n)
                stringBuilder.append("h2 ");
            if (n == 10)
                stringBuilder.append("h3 ");
            for (int i = 11; i <= n; i++) {
                char c = (char) ('g' + 11 - i);
                stringBuilder.append(c + "2 ");
            }
            if (11 <= n && n <= 17) {
                char c = (char) (Math.max('g' + 11 - n, 'a'));
                stringBuilder.append(c + "8 ");
            }
            stringBuilder.append("h8 ");
        }
        System.out.println(stringBuilder);
        bufferedReader.close();
    }
}