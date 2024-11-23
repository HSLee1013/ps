package programmers.nov_third.p43163;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}) + "";
        System.out.println(s);
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        int[] depth = new int[words.length];
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < words.length; i++) {
            if (isLinked(begin, words[i])) {
                depth[i]++;
                que.add(i);
            }
        }
        while (!que.isEmpty()) {
            int ci = que.poll();
            if (words[ci].equals(target)) {
                return depth[ci];
            }
            for (int i = 0; i < words.length; i++) {
                if (depth[i] > 0)
                    continue;
                if (isLinked(words[ci], words[i])) {
                    depth[i] = depth[ci] + 1;
                    que.add(i);
                }
            }
        }
        return 0;
    }

    private boolean isLinked(String wordA, String wordB) {
        int count = 0;
        for (int i = 0; i < wordA.length(); i++) {
            if (wordA.charAt(i) == wordB.charAt(i))
                continue;
            count++;
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}