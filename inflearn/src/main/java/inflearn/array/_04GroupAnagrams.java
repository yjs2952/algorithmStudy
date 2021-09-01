package inflearn.array;

import java.util.*;

public class _04GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(solution(new String[]{""}));
    }

    private static List<List<String>> solution(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            String key = String.valueOf(charArray);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
