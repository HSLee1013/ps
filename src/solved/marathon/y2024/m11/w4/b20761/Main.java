package solved.marathon.y2024.m11.w4.b20761;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        double c = Math.min(Double.parseDouble(bufferedReader.readLine()), 1);
        System.out.println(c * c / 4);
        bufferedReader.close();
    }
}