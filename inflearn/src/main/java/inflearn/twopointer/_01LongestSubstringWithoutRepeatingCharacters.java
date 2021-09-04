package inflearn.twopointer;

import java.util.HashMap;
import java.util.Map;

public class _01LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(solution("abcabcd"));
        System.out.println(solution("pwwkea"));
        System.out.println(solution("aaaaa"));
        System.out.println(solution(""));
        System.out.println(solution("abcabcbb"));
        System.out.println(solution("dvdf"));
    }

    private static int solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, counter = 0, max = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.get(ch) > 1) {
                counter++;
            }
            right++;

            while (counter > 0) {
                char ch2 = s.charAt(left);
                if (map.get(ch2) > 1) {
                    counter--;
                }
                map.put(ch2, map.get(ch2) - 1);
                left++;
            }
            max = Math.max(max, right - left);
        }

        return max;
    }
}
