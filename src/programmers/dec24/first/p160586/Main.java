package programmers.dec24.first.p160586;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = Arrays.toString(solution.solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"})) + "";
        System.out.println(s);
    }
}

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] alphabet = new int[26];
        for (String key : keymap) {
            int index = 1;
            for (char c : key.toCharArray()) {
                alphabet[c - 'A'] = alphabet[c - 'A'] == 0 ? index : Math.min(alphabet[c - 'A'], index);
                index++;
            }
        }
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int result = 0;
            for (char c : target.toCharArray()) {
                if (alphabet[c - 'A'] == 0) {
                    result = -1;
                    break;
                }
                result += alphabet[c - 'A'];
            }
            answer[i] = result;
        }
        return answer;
    }
}