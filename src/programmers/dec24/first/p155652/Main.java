package programmers.dec24.first.p155652;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution("aukks", "wbqd", 5) + "";
        System.out.println(s);
    }
}

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        skip = Arrays.stream(skip.split("")).sorted().collect(Collectors.joining());
        for (char c : s.toCharArray()) {
            int cs = c + index;
            for (char cc : skip.toCharArray()) {
                if (cs < cc)
                    break;
                if (c < cc) {
                    cs++;
                }
            }
            while (cs > 'z') {
                cs = cs - 'z' - 1 + 'a';
                for (char cc : skip.toCharArray()) {
                    if (cs < cc)
                        break;
                    cs++;
                }
            }
            answer.append((char) cs);
        }
        return answer.toString();
    }
}