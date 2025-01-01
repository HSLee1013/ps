package solved.marathon.y2024.m11.w4.c4197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            Turtle turtle = new Turtle();
            for (int j = 0; j < n; j++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                String command = stringTokenizer.nextToken();
                int value = Integer.parseInt(stringTokenizer.nextToken());
                switch (command) {
                    case "bk":
                        value *= -1;
                    case "fd":
                        turtle.move(value);
                        break;
                    case "rt":
                        value *= -1;
                    case "lt":
                        turtle.turn(value);
                        break;
                }
            }
            stringBuilder.append(turtle.getDistance()).append('\n');
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}

class Turtle {
    private double x, y, degree;

    public void move(int dist) {
        x += Math.cos(Math.toRadians(degree)) * dist;
        y += Math.sin(Math.toRadians(degree)) * dist;
    }

    public void turn(int degree) {
        this.degree += degree;
    }

    public long getDistance() {
        return Math.round(Math.sqrt(x * x + y * y));
    }
}