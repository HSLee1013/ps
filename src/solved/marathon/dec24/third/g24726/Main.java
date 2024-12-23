package solved.marathon.dec24.third.g24726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int x1 = Integer.parseInt(stringTokenizer.nextToken());
        int y1 = Integer.parseInt(stringTokenizer.nextToken());
        int x2 = Integer.parseInt(stringTokenizer.nextToken());
        int y2 = Integer.parseInt(stringTokenizer.nextToken());
        int x3 = Integer.parseInt(stringTokenizer.nextToken());
        int y3 = Integer.parseInt(stringTokenizer.nextToken());
        double area = Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0;
        double xPerimeter = (y1 + y2 + y3) / 3.0 * 2 * Math.PI;
        double yPerimeter = (x1 + x2 + x3) / 3.0 * 2 * Math.PI;
        System.out.println(area * xPerimeter + " " + area * yPerimeter);

        bufferedReader.close();
    }
}