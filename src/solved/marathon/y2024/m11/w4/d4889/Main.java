package solved.marathon.y2024.m11.w4.d4889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int index = 1;
        String line;
        while (!(line = bufferedReader.readLine()).startsWith("-")) {
            int result = 0;
            int count = 0;
            for (char c : line.toCharArray()) {
                if (c == '{') {
                    count++;
                } else {
                    if (count < 1) {
                        result++;
                        count++;
                    } else {
                        count--;
                    }
                }
            }
            result += count / 2;
            stringBuilder.append(index++).append(". ").append(result).append('\n');
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}