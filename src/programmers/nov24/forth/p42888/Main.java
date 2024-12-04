package programmers.nov24.forth.p42888;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = Arrays.toString(solution.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})) + "";
        System.out.println(s);
    }
}

class Solution {
    public String[] solution(String[] record) {
        List<String> log = new ArrayList<>();
        List<String> uid = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (String s : record) {
            String[] ss = s.split(" ");
            if (ss[0].equals("Enter")) {
                uid.add(ss[1]);
                log.add("님이 들어왔습니다.");
                map.put(ss[1], ss[2]);
            } else if (ss[0].equals("Leave")) {
                uid.add(ss[1]);
                log.add("님이 나갔습니다.");
            } else if (ss[0].equals("Change")) {
                map.put(ss[1], ss[2]);
            }
        }
        for (int i = 0; i < log.size(); i++) {
            log.set(i, map.get(uid.get(i)) + log.get(i));
        }
        return log.toArray(new String[0]);
    }
}