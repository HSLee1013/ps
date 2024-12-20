package programmers.dec24.third.p42746;

import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        String answer = Arrays.stream(numbers).mapToObj(String::valueOf).sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2)).collect(Collectors.joining());
        return answer.startsWith("0") ? "0" : answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(new int[]{0, 0, 0}) + "";
        System.out.println(s);
    }
}