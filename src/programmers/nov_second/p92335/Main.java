package programmers.nov_second.p92335;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(437674, 3) + "";
        System.out.println(s);
    }
}

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] split = Integer.toString(n, k).split("0");
        for (String s : split) {
            if (s.isEmpty())
                continue;
            long l = Long.parseLong(s);
            if (isPrime(l))
                answer++;
        }
        return answer;
    }

    private boolean isPrime(long n) {
        if (n == 1)
            return false;
        for (long l = 2; l * l <= n; l++) {
            if (n % l == 0)
                return false;
        }
        return true;
    }
}
