package programmers.y2024.m11.w3.a12927;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(10, new int[]{10, 10, 1}) + "";
        System.out.println(s);
    }
}

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : works) {
            que.add(i);
        }
        while (n > 0) {
            int cur = que.poll();
            if (cur == 0)
                break;
            que.add(cur - 1);
            n--;
        }
        for (int i : que) {
            int cur = Math.max(i, 0);
            answer += cur * cur;
        }
        return answer;
    }
}
