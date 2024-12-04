package programmers.nov24.second.p84512;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution("I") + "";
        System.out.println(s);
    }
}

class Solution {
    public int solution(String word) {
        int answer = 0;
        int[] count = {781, 156, 31, 6, 1};
        String vowels = "AEIOU";
        for (int i = 0; i < word.length(); i++) {
            answer += vowels.indexOf(word.charAt(i)) * count[i] + 1;
        }
        return answer;
    }
}
