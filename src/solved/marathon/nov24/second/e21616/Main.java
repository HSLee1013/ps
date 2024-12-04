package solved.marathon.nov24.second.e21616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bufferedReader.readLine());
        int n = Integer.parseInt(bufferedReader.readLine());
        int k = Integer.parseInt(bufferedReader.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            String command = bufferedReader.readLine();
            if (set.contains(command)) {
                set.remove(command);
            } else {
                set.add(command);
            }
        }
        int r = 0, c = 0;
        for (String s : set) {
            if (s.startsWith("R"))
                r++;
            else
                c++;
        }
        System.out.println(r * n + c * m - r * c * 2);
        bufferedReader.close();
    }
}