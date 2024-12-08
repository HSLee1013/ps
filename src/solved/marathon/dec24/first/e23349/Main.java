package solved.marathon.dec24.first.e23349;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Set<String> names = new HashSet<>();
        Map<String, int[]> map = new HashMap<>();
        PriorityQueue<String> places = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String name = stringTokenizer.nextToken();
            if (names.contains(name)) {
                continue;
            }
            names.add(name);
            String place = stringTokenizer.nextToken();
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            int[] time;
            if (map.containsKey(place)) {
                time = map.get(place);
            } else {
                time = new int[50001];
                map.put(place, time);
            }
            int curMax = 0;
            for (int j = start; j < end; j++) {
                time[j]++;
                curMax = Math.max(curMax, time[j]);
            }
            if (curMax > max) {
                max = curMax;
                places.clear();
                places.add(place);
            } else if (curMax == max) {
                places.add(place);
            }
        }
        String place = places.poll();
        int[] time = map.get(place);
        int start = 0;
        int end = 0;
        for (int i = 1; i < 50001; i++) {
            if (start == 0) {
                if (time[i] == max) {
                    start = i;
                }
            } else {
                if (time[i] != max) {
                    end = i;
                    break;
                }
            }
        }
        System.out.println(place + " " + start + " " + end);
        bufferedReader.close();
    }
}