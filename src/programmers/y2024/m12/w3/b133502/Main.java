package programmers.y2024.m12.w3.b133502;

import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int i : ingredient) {
            if (i == 1 && stack.size() > 2 && stack.get(stack.size() - 1) == 3 && stack.get(stack.size() - 2) == 2 && stack.get(stack.size() - 3) == 1) {
                stack.pop();
                stack.pop();
                stack.pop();
                answer++;
            } else {
                stack.push(i);
            }
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}) + "";
        System.out.println(s);
    }
}