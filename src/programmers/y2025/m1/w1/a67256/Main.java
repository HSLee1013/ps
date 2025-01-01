package programmers.y2025.m1.w1.a67256;

class Solution {
    StringBuilder stringBuilder = new StringBuilder();
    int n;
    int l = 10;
    int r = 12;

    public String solution(int[] numbers, String hand) {
        for (int i = 0; i < numbers.length; i++) {
            n = numbers[i] == 0 ? 11 : numbers[i];
            if (n == 1 || n == 4 || n == 7) {
                addL();
            } else if (n == 3 || n == 6 || n == 9) {
                addR();
            } else {
                int ld = dist(l, n);
                int rd = dist(r, n);
                if (ld == rd) {
                    if (hand.charAt(0) == 'l') {
                        addL();
                    } else {
                        addR();
                    }
                } else if (ld < rd) {
                    addL();
                } else {
                    addR();
                }
            }
        }
        return stringBuilder.toString();
    }

    private void addL() {
        stringBuilder.append('L');
        l = n;
    }

    private void addR() {
        stringBuilder.append('R');
        r = n;
    }

    private int dist(int a, int b) {
        int ax = (a - 1) % 3 + 1;
        int ay = (a - 1) / 3;
        int bx = (b - 1) % 3 + 1;
        int by = (b - 1) / 3;
        return Math.abs(ax - bx) + Math.abs(ay - by);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right") + "";
        System.out.println(s);
    }
}