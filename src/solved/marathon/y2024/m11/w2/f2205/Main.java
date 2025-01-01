package solved.marathon.y2024.m11.w2.f2205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());
        int result[] = new int[n + 1];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        for (int i = n; i >= 1; i--) {
            int sum = i + list.get(list.size() - 1);
            String bin = Integer.toBinaryString(sum);
            int len = bin.length();
            if (!bin.substring(1).contains("1")) {
                result[i] = list.remove(list.size() - 1);
                continue;
            }
            int pow = (int) Math.pow(2, len - 1);
            result[i] = list.remove(list.indexOf(pow - i));
        }
        for (int i = 1; i <= n; i++) {
            stringBuilder.append(result[i]).append('\n');
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}