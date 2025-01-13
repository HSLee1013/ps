package programmers.y2025.m1.w2.f17683;

class Solution {
    String[] sound = {"A#", "B#", "C#", "D#", "F#", "G#"};

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max = 0;
        for (int i = 0; i < sound.length; i++) {
            m = m.replace(sound[i], String.valueOf(i));
        }
        for (String musicinfo : musicinfos) {
            String[] split = musicinfo.split(",");
            int time = time(split[1]) - time(split[0]);
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < sound.length; i++) {
                split[3] = split[3].replace(sound[i], String.valueOf(i));
            }
            while (stringBuilder.length() < time) {
                stringBuilder.append(split[3]);
            }
            if (stringBuilder.substring(0, time).contains(m)) {
                if (max < time) {
                    max = time;
                    answer = split[2];
                }
            }

        }
        return answer;
    }

    private int time(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution("A#", new String[]{"12:00,12:01,HELLO,A#"}) + "";
        System.out.println(s);
    }
}