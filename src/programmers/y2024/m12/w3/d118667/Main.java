package programmers.y2024.m12.w3.d118667;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int[] sum = new int[queue1.length + queue2.length];
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < queue1.length; i++) {
            sum[i] = queue1[i];
            sum1 += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            sum[queue1.length + i] = queue2[i];
            sum2 += queue2[i];
        }
        if ((sum1 + sum2) % 2 == 1)
            return -1;
        long avg = (sum1 + sum2) / 2;
        int l = 0, r = queue1.length;
        while (l < r && sum1 != avg && r < sum.length) {
            if (sum1 > avg) {
                sum1 -= sum[l];
                l++;
            } else {
                sum1 += sum[r];
                r++;
            }
            answer++;
        }
        return sum1 != avg ? -1 : answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}) + "";
        System.out.println(s);
    }
}