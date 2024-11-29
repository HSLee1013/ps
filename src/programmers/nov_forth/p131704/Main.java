package programmers.nov_forth.p131704;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(new int[]{5, 4, 3, 2, 1}) + "";
        System.out.println(s);
    }
}

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= order.length; i++) {
            stack.add(i);
            while (!stack.isEmpty()) {
                if (stack.peek() == order[answer]) {
                    stack.pop();
                    answer++;
                } else {
                    break;
                }
            }
        }
        return answer;
    }
}