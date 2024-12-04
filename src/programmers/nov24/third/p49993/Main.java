package programmers.nov24.third.p49993;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}) + "";
        System.out.println(s);
    }
}

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        for (int i = 0; i < skill_trees.length; i++) {
            int cur = 0;
            for (char c : skill_trees[i].toCharArray()) {
                int index = skill.indexOf(c);
                if (index == -1)
                    continue;
                if (index != cur) {
                    answer--;
                    break;
                }
                cur++;
            }
        }
        return answer;
    }
}