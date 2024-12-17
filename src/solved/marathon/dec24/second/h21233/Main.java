package solved.marathon.dec24.second.h21233;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        Set<Integer> set = new TreeSet<>();
        int max = 0;
        set.add(0);
        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(bufferedReader.readLine()) / 12 + 1;
            set.add(c);
            max = Math.max(max, c);
        }
        int result = max * 12;
        int prev = 0;
        List<Integer> list = new ArrayList<>();
        for (int i : set) {
            list.add(i - prev);
            prev = i;
        }
        list.sort(Comparator.reverseOrder());
        for (int i = 0; i < k - 1 && i < list.size(); i++) {
            result -= (list.get(i) - 1) * 12;
        }
        System.out.println(result);
        bufferedReader.close();
    }
}
