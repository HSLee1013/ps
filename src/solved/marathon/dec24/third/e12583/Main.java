package solved.marathon.dec24.third.e12583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            n = Integer.parseInt(stringTokenizer.nextToken());
            k = Integer.parseInt(stringTokenizer.nextToken());
            char[][] board = new char[n][];
            for (int j = 0; j < n; j++) {
                board[j] = bufferedReader.readLine().toCharArray();
            }
            stringBuilder.append("Case #").append(i + 1).append(": ");
            switch (check(gravity(lotate(board)))) {
                case 0:
                    stringBuilder.append("Neither").append("\n");
                    break;
                case 1:
                    stringBuilder.append("Red").append("\n");
                    break;
                case 2:
                    stringBuilder.append("Blue").append("\n");
                    break;
                case 3:
                    stringBuilder.append("Both").append("\n");
                    break;
            }
        }

        System.out.print(stringBuilder);
        bufferedReader.close();
    }

    private static char[][] lotate(char[][] board) {
        char[][] result = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = board[n - 1 - j][i];
            }
        }
        return result;
    }

    private static char[][] gravity(char[][] board) {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    int cur = i - 1;
                    while (cur >= 0) {
                        if (board[cur][j] != '.') {
                            board[i][j] = board[cur][j];
                            board[cur][j] = '.';
                            break;
                        }
                        cur--;
                    }
                }
            }
        }
        return board;
    }

    private static int check(char[][] board) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                if ((result & 1) != 0 && board[i][j] == 'R') continue;
                if ((result & 2) != 0 && board[i][j] == 'B') continue;
                if (checkSame(board, i, j, 1, 0) ||
                        checkSame(board, i, j, 0, 1) ||
                        checkSame(board, i, j, 1, 1) ||
                        checkSame(board, i, j, -1, 1)) {
                    result |= board[i][j] == 'R' ? 1 : 2;
                }
                if (result == 3) break;
            }
        }
        return result;
    }

    private static boolean checkSame(char[][] board, int x, int y, int dx, int dy) {
        char cur = board[x][y];
        for (int i = 1; i < k; i++) {
            int nx = x + i * dx;
            int ny = y + i * dy;
            if (nx < 0 || nx >= n || ny >= n || board[nx][ny] != cur) {
                return false;
            }
        }
        return true;
    }
}
