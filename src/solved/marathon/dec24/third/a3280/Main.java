package solved.marathon.dec24.third.a3280;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int d = Integer.parseInt(bufferedReader.readLine());
        int[][] c = new int[n / 3][3];
        Set<Integer> set = null;
        for (int i = 0; i < n; i++) {
            c[i / 3][i % 3] = i + 1;
        }
        for (int i = 0; i < d; i++) {
            String s = bufferedReader.readLine();
            Set<Integer> temp = new HashSet<>();
            int k = 2;
            if (s.equals("first")) {
                k = 0;
            } else if (s.equals("second")) {
                k = 1;
            }
            for (int j = 0; j < n / 3; j++) {
                temp.add(c[j][k]);
            }
            if (i == 0)
                set = temp;
            else
                set.retainAll(temp);
            int[][] c2 = new int[n / 3][3];
            int index = 0;
            for (int j = 0; j < 3; j++) {
                for (int l = 0; l < n / 3; l++) {
                    c2[index / 3][index % 3] = c[l][j];
                    index++;
                }
            }
            c = c2;
        }
        for (int i : set) {
            System.out.print(i + " ");
        }
        bufferedReader.close();
    }
}
