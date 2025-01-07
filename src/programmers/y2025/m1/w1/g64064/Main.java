package programmers.y2025.m1.w1.g64064;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    List<Integer>[] list;
    Set<Integer> set = new TreeSet<>();
    Set<String> resultSet = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        list = new List[banned_id.length];
        for (int i = 0; i < banned_id.length; i++) {
            list[i] = new ArrayList<>();
            Pattern p = Pattern.compile(banned_id[i].replace("*", "."));
            for (int j = 0; j < user_id.length; j++) {
                Matcher m = p.matcher(user_id[j]);
                if (m.matches()) {
                    list[i].add(j);
                }
            }
        }
        check(0);
        return resultSet.size();
    }

    private void check(int n) {
        if (n == list.length) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i : set) {
                stringBuilder.append(i);
            }
            resultSet.add(stringBuilder.toString());
            return;
        }
        for (int i = 0; i < list[n].size(); i++) {
            set.add(list[n].get(i));
            if (set.size() != n + 1) continue;
            check(n + 1);
            set.remove(list[n].get(i));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}) + "";
        System.out.println(s);
    }
}