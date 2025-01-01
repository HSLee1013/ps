package programmers.y2024.m12.w3.g42583;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int count = 0;
        int[] truck_move = new int[truck_weights.length];
        int bridge_weight = 0;
        while (truck_move[truck_weights.length - 1] <= bridge_length) {
            for (int i = 0; i < truck_weights.length; i++) {
                if (truck_move[i] == 0 || truck_move[i] > bridge_length) continue;
                truck_move[i]++;
                if (truck_move[i] > bridge_length) {
                    bridge_weight -= truck_weights[i];
                }
            }
            if (count < truck_weights.length && bridge_weight + truck_weights[count] <= weight) {
                truck_move[count]++;
                bridge_weight += truck_weights[count];
                count++;
            }
            answer++;
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}) + "";
        System.out.println(s);
    }
}