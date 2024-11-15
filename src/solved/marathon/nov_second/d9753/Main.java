package solved.marathon.nov_second.d9753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> mulList = getMulList();
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(bufferedReader.readLine());
            stringBuilder.append(mulList.get(find(0, mulList.size(), k, mulList))).append('\n');
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }

    private static List<Integer> getMulList() {
        List<Integer> prime = new ArrayList<>();
        Set<Integer> mulSet = new TreeSet<>();
        for (int i = 2; i < 50000; i++) {
            if (isPrime(i))
                prime.add(i);
        }
        for (int i = 0; i < prime.size() - 1; i++) {
            for (int j = i + 1; j < prime.size(); j++) {
                int mul = prime.get(i) * prime.get(j);
                if (mul <= 100001 && mul > 0)
                    mulSet.add(mul);
            }
        }
        return new ArrayList<>(mulSet);
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static int find(int s, int e, int k, List<Integer> list) {
        while (s < e) {
            int mid = (s + e) / 2;
            if (list.get(mid) >= k) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }
}