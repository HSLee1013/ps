package programmers.y2024.m12.w4.a42839;

import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;
        addSet("", numbers);
        System.out.println(set);
        for (int i : set) {
            if (isPrime(i))
                answer++;
        }
        return answer;
    }

    public void addSet(String s, String ss) {
        if (!s.isEmpty()) {
            set.add(Integer.parseInt(s));
        }
        for (int i = 0; i < ss.length(); i++) {
            addSet(s + ss.charAt(i), ss.substring(0, i) + ss.substring(i + 1));
        }
    }

    private boolean isPrime(int number) {
        if (number == 0 || number == 1) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution("011") + "";
        System.out.println(s);
    }
}