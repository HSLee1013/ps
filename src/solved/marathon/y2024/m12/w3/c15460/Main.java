package solved.marathon.y2024.m12.w3.c15460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] sum = new int[n + 1];
        int[] score = new int[n + 1];
        int[] min = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(stringTokenizer.nextToken());
            sum[i] = sum[i - 1] + score[i];
        }
        int m = score[n];
        min[n - 1] = m;
        for (int i = n - 2; i >= 1; i--) {
            min[i] = Math.min(min[i + 1], score[i + 1]);
        }

        List<Integer> list = new ArrayList<>();
        double max = 0;
        for (int i = 1; i < n - 1; i++) {
            double avg = (double) (sum[n] - sum[i] - min[i]) / (n - i - 1);
            if (avg > max) {
                list.clear();
                list.add(i);
                max = avg;
            } else if (avg == max) {
                list.add(i);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : list) {
            stringBuilder.append(i).append('\n');
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}
