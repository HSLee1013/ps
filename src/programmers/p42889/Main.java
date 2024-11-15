package programmers.p42889;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = Arrays.toString(solution.solution(4, new int[]{4, 4, 4, 4, 4}));
        System.out.println(s);
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] p = new int[N + 1];
        int[] sum = new int[N + 1];
        double[][] fails = new double[N][2];
        for (int stage : stages) {
            if (stage > N)
                p[N]++;
            else
                p[stage - 1]++;
        }
        sum[N] = p[N];
        for (int i = N - 1; i >= 0; i--) {
            sum[i] = sum[i + 1] + p[i];
        }
        for (int i = 0; i < N; i++) {
            fails[i][0] = sum[i] == 0 ? 0 : (double) p[i] / sum[i];
            fails[i][1] = i;
        }
        Arrays.sort(fails, ((o1, o2) -> {
            if (o1[0] == o2[0])
                return Double.compare(o1[1], o2[1]);
            return Double.compare(o2[0], o1[0]);
        }));
        for (int i = 0; i < N; i++) {
            answer[i] = (int) fails[i][1] + 1;
        }
        return answer;
    }
}
