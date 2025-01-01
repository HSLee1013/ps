package solved.marathon.y2024.m12.w3.f22965;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] a = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int count = 0;
        int prev = 0;
        int prevMin = 0;
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(stringTokenizer.nextToken());
            if (prev > cur) {
                count++;
            }
            if (count == 1 && cur > prevMin) {
                count++;
            }
            if (count > 1)
                break;
            if (prevMin == 0)
                prevMin = cur;
            prev = cur;
        }
        if (count == 0) System.out.println(1);
        else if (count == 1) System.out.println(2);
        else System.out.println(3);
        bufferedReader.close();
    }
}
