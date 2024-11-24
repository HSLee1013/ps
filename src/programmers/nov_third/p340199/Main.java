package programmers.nov_third.p340199;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(new int[]{30, 15}, new int[]{26, 17}) + "";
        System.out.println(s);
    }
}

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while (true) {
            int walletMin = Math.min(wallet[0], wallet[1]);
            int walletMax = Math.max(wallet[0], wallet[1]);
            int billMin = Math.min(bill[0], bill[1]);
            int billMax = Math.max(bill[0], bill[1]);
            if (billMin <= walletMin && billMax <= walletMax)
                break;
            if (bill[0] > bill[1])
                bill[0] /= 2;
            else
                bill[1] /= 2;
            answer++;
        }
        return answer;
    }
}