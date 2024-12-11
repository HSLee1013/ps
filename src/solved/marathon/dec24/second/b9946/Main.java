package solved.marathon.dec24.second.b9946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        String s;
        int count = 1;
        while (!(s = bufferedReader.readLine()).equals("END")) {
            stringBuilder.append("Case " + count + ": ");
            String ss = bufferedReader.readLine();
            int[] alp = new int[26];
            for (char c : s.toCharArray()) {
                alp[c - 'a']++;
            }
            boolean same = true;
            for (char c : ss.toCharArray()) {
                alp[c - 'a']--;
            }
            for (int i = 0; i < 26; i++) {
                if (alp[i] != 0) {
                    same = false;
                    break;
                }
            }
            stringBuilder.append(same ? "same\n" : "different\n");
            count++;
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}