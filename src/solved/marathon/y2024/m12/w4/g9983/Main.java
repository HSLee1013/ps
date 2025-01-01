package solved.marathon.y2024.m12.w4.g9983;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] king = {{0, 1}, {1, 1}, {0, -1}, {1, -1}, {1, 0}, {-1, 1}, {-1, 0}, {-1, -1}};
    static int[][] knight = {{2, 1}, {1, 2}, {1, -2}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
    static int h;
    static int w;
    static String[][] sBoard;
    static int[][] pieces = new int[16][2];
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.equals("START"))
                break;
            w = Integer.parseInt(bufferedReader.readLine());
            h = Integer.parseInt(bufferedReader.readLine());
            sBoard = new String[h][];
            count = 0;
            for (int i = 0; i < h; i++) {
                line = bufferedReader.readLine();
                sBoard[i] = line.split(" ");
                for (int j = 0; j < w; j++) {
                    if (sBoard[i][j].equals("E"))
                        continue;
                    pieces[count][0] = i;
                    pieces[count][1] = j;
                    count++;
                }
            }
            int result = count;
            for (int i = 0; i < (1 << count); i++) {
                if (solve(i)) {
                    result = Math.min(result, count - Integer.bitCount(i));
                }
            }
            stringBuilder.append("Minimum Number of Pieces to be removed: ").append(result).append('\n');
            line = bufferedReader.readLine();
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }

    static boolean inBoard(int x, int y) {
        return (x >= 0 && y >= 0 && x < h && y < w);
    }

    static boolean check(int x, int y, String piece, boolean[][] bBoard) {
        if (piece.equals("K") || piece.equals("N")) {
            int[][] moves = (piece.equals("K")) ? king : knight;

            for (int i = 0; i < 8; i++) {
                int nx = moves[i][0] + x;
                int ny = moves[i][1] + y;
                if (inBoard(nx, ny) && bBoard[nx][ny]) return false;
            }
        } else {
            int[][] moves = king;
            int steps = 10;

            for (int i = 1; i <= steps; i++) {
                for (int j = (piece.equals("B") ? 1 : 0); j < 8; j += (piece.equals("Q") ? 1 : 2)) {
                    int nx = moves[j][0] * i + x;
                    int ny = moves[j][1] * i + y;
                    if (inBoard(nx, ny) && bBoard[nx][ny]) return false;
                }
            }
        }
        return true;
    }

    static boolean solve(int mask) {
        boolean[][] bBoard = new boolean[10][10];

        for (int i = 0; i < count; i++) {
            if ((mask & (1 << i)) != 0) {
                bBoard[pieces[i][0]][pieces[i][1]] = true;
            }
        }

        for (int i = 0; i < count; i++) {
            if ((mask & (1 << i)) == 0) continue;

            int x = pieces[i][0];
            int y = pieces[i][1];
            String piece = sBoard[x][y];

            if (!check(x, y, piece, bBoard)) {
                return false;
            }
        }
        return true;
    }
}