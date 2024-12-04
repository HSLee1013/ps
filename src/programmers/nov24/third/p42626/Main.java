package programmers.nov24.third.p42626;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(new int[]{1, 2, 3, 9, 10, 12}, 7) + "";
        System.out.println(s);
    }
}

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i : scoville) {
            priorityQueue.add(i);
        }
        while (priorityQueue.peek() < K) {
            if (priorityQueue.size() == 1) {
                return -1;
            }
            int a = priorityQueue.poll();
            int b = priorityQueue.poll();
            priorityQueue.add(a + b * 2);
            answer++;
        }
        return answer;
    }
}
