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
        String input1 = "eceba";
        String input2 = "ccaabbb";

        System.out.println(lengthOfLongestSubstringTwoDistinct(input1));
        System.out.println(lengthOfLongestSubstringTwoDistinct(input2));

    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int start = 0, end = 0, distCnt = 0, length = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (end < s.length()) {
            char endChar = s.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);

            if (map.get(endChar) == 1) distCnt++;
            end++;
            while (distCnt > 2) {
                char startChar = s.charAt(start);

                map.put(startChar, map.get(startChar) - 1);

                if (map.get(startChar) == 0) {
                    distCnt--;
                }
                start++;
            }

            length = Math.max(length, end - start);
        }

        return length;
    }
}
