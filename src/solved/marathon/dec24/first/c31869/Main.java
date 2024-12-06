package solved.marathon.dec24.first.c31869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Map<String, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String s = stringTokenizer.nextToken();
            int d = Integer.parseInt(stringTokenizer.nextToken()) * 7 + Integer.parseInt(stringTokenizer.nextToken());
            int p = Integer.parseInt(stringTokenizer.nextToken());
            map.put(s, new int[]{d, p});
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String s = stringTokenizer.nextToken();
            int m = Integer.parseInt(stringTokenizer.nextToken());
            if (map.get(s)[1] > m) {
                map.remove(s);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int[] v : map.values()) {
            list.add(v[0]);
        }
        list.sort(Comparator.naturalOrder());
        if (list.isEmpty()) {
            System.out.println(0);
        } else {
            int prev = list.get(0);
            int count = 1;
            int result = 1;
            for (int i = 1; i < list.size(); i++) {
                if (prev + 1 == list.get(i))
                    count++;
                else if (prev == list.get(i))
                    continue;
                else
                    count = 1;
                prev = list.get(i);
                result = Math.max(result, count);
            }
            System.out.println(result);
        }
        bufferedReader.close();
    }
}