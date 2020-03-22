package problem_11_to_20;

import java.util.HashMap;
import java.util.Map;

public class _12LongestSubMostTwoDist {

    /**
     * Given a string s , find the length of the longest substring t that contains at most 2 distinct characters.
     * Example 1:
     * Input: "eceba"
     * Output: 3
     * Explanation: t is "ece" which its length is 3.
     *
     * Example 2:
     * Input: "ccaabbb"
     * Output: 5
     * Explanation: t is "aabbb" which its length is 5.
     */
    public static void main(String[] args) {
        String input1 = "ececa";
        String input2 = "ccaabbb";

        System.out.println(lengthOfLongestSubstringTwoDistinct(input1));
        System.out.println(lengthOfLongestSubstringTwoDistinct(input2));

    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int end = 0, start = 0, cnt = 0, length = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (end < s.length()) {
            char key = s.charAt(end);
            map.put(key, map.getOrDefault(key, 0) + 1);

            if (map.get(key) == 1) {
                cnt++;
            }

            end++;
            while (cnt > 2) {
                char c = s.charAt(start);
                map.put(c, map.get(c) - 1);

                if (map.get(c) == 0) {
                    cnt--;
                }
                start++;
            }

            length = Math.max(length, end - start);
        }

        return length;
    }
}
