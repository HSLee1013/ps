package solved.marathon.dec24.first.f17799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        list.sort(Comparator.naturalOrder());
        int s = 0, e = list.size() - 1;
        int result = 0;
        while (s <= e) {
            if (list.get(s) + list.get(e) <= c) {
                s++;
            }
            result++;
            e--;
        }
        System.out.println(result);
        bufferedReader.close();
    }
}