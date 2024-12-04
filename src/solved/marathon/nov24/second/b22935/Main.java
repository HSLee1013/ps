package solved.marathon.nov24.second.b22935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            int n = (Integer.parseInt(bufferedReader.readLine()) - 1) % 28 + 1;
            n = n > 15 ? 30 - n : n;
            stringBuilder.append(String.format("%4s", Integer.toBinaryString(n)).replaceAll("1", "딸기").replaceAll("[ 0]", "V")).append('\n');
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}
