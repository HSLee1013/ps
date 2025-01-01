package solved.marathon.y2024.m11.w2.h16472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String s = bufferedReader.readLine();
        int l = 0;
        int r = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 1);
        int result = 1;
        while (true) {
            if (map.size() > n) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if (map.get(s.charAt(l)) == 0)
                    map.remove(s.charAt(l));
                l++;
            } else {
                result = Math.max(result, r - l + 1);
                r++;
                if (r == s.length())
                    break;
                map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            }
        }
        System.out.println(result);
        bufferedReader.close();
    }
}