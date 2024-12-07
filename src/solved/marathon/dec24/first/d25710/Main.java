package solved.marathon.dec24.first.d25710;

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
        boolean[] muls = new boolean[1000000];
        int[] dup = new int[1000];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(stringTokenizer.nextToken());
            if (dup[a] == 2) continue;
            dup[a]++;
            list.add(a);
        }
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int mul = list.get(i) * list.get(j);
                if (muls[mul]) {
                    continue;
                }
                muls[mul] = true;
                int sum = 0;
                while (mul > 0) {
                    sum += mul % 10;
                    mul /= 10;
                }
                result = Math.max(result, sum);
            }
        }
        System.out.println(result);
        bufferedReader.close();
    }
}