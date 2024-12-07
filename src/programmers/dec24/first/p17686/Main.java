package programmers.dec24.first.p17686;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = Arrays.toString(solution.solution(new String[]{"foo.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})) + "";

        System.out.println(s);
    }
}

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        Arrays.sort(files, (o1, o2) -> {
            String[] s1 = split(o1);
            String[] s2 = split(o2);
            String h1 = s1[0];
            String h2 = s2[0];
            if (h1.compareToIgnoreCase(h2) == 0) {
                Integer n1 = Integer.valueOf(s1[1]);
                Integer n2 = Integer.valueOf(s2[1]);
                return n1.compareTo(n2);
            }
            return h1.compareToIgnoreCase(h2);
        });
        return files;
    }

    public String[] split(String s) {
        String h = s.split("\\d")[0];
        String n = s.substring(h.length()).split("\\D")[0];
        return new String[]{h, n};
    }
}