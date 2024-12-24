package solved.marathon.dec24.third.h1771;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());
        Stack<int[]> stack = new Stack<>();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int[] cur = {a, a, i};
            if (stack.isEmpty()) {
                stack.add(cur);
                continue;
            }
            while (!stack.isEmpty()) {
                int[] prev = stack.peek();
                if (prev[0] - 1 == cur[1]) {
                    stack.pop();
                    stringBuilder.append(cur[2]).append('\n');
                    cur[1] = prev[1];
                    cur[2] = prev[2];
                } else if (prev[1] + 1 == cur[0]) {
                    stack.pop();
                    stringBuilder.append(cur[2]).append('\n');
                    cur[0] = prev[0];
                    cur[2] = prev[2];
                } else {
                    break;
                }
            }
            stack.push(cur);
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}