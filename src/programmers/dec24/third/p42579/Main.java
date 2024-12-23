package programmers.dec24.third.p42579;

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> resultList = new ArrayList<>();
        List<Music> musicList = new ArrayList<>();
        Map<String, Integer> playMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            musicList.add(new Music(i, genres[i], plays[i]));
            playMap.put(genres[i], playMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        musicList.sort((o1, o2) -> {
            if (playMap.get(o1.genre).equals(playMap.get(o2.genre))) {
                if (o1.play == o2.play) {
                    return o1.index - o2.index;
                }
                return o2.play - o1.play;
            }
            return playMap.get(o2.genre) - playMap.get(o1.genre);
        });
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < musicList.size(); i++) {
            String genre = musicList.get(i).genre;
            if (countMap.getOrDefault(genre, 0) == 2) {
                continue;
            }
            countMap.put(genre, countMap.getOrDefault(genre, 0) + 1);
            resultList.add(musicList.get(i).index);
        }
        return resultList.stream().mapToInt(i -> i).toArray();
    }
}

class Music {
    int index;
    String genre;
    int play;

    Music(int index, String genre, int play) {
        this.index = index;
        this.genre = genre;
        this.play = play;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = Arrays.toString(solution.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})) + "";
        System.out.println(s);
    }
}