package solved.marathon.dec24.second.g1112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int x = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());
        boolean chk = false;
        if (x < 0 && b > 0) {
            chk = true;
            x = -x;
        }
        while (x != 0) {
            int m = x % b;
            x /= b;
            if (m < 0) {
                x++;
                m -= b;
            }
            stringBuilder.append(m);
        }
        if (chk)
            stringBuilder.append('-');
        System.out.println(stringBuilder.length() > 0 ? stringBuilder.reverse() : 0);
        bufferedReader.close();
    }
}
