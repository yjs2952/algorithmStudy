package problem_11_to_20;

import java.util.ArrayList;
import java.util.List;

public class _15FindAllAnagrams {
    /**
     * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
     * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
     * The order of output does not matter.
     * Example 1:
     * Input:
     * s: "cbaebabacd" p: "abc"
     * Output:
     * [0, 6]
     * Explanation:
     * The substring with start index = 0 is "cba", which is an anagram of "abc".
     * The substring with start index = 6 is "bac", which is an anagram of "abc".
     */
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String txt, String pat) {
        List<Integer> result = new ArrayList<>();

        if (txt == null || txt.length() <= 0 || pat == null || pat.length() <= 0 || txt.length() < pat.length())
            return result;

        int[] patArr = new int[256];
        boolean isSame = true;

        for (int i = 0; i < pat.length(); i++) {
            patArr[pat.charAt(i)]++;
        }

        for (int i = 0; i < txt.length() - pat.length() + 1; i++) {
            int[] txtArr = new int[256];

            for (int j = 0; j < pat.length(); j++) {
                txtArr[txt.charAt(i + j)]++;
            }

//            if (check(patArr, txtArr)) {
//                result.add(i);
//            }

            for (int k = 0; k < patArr.length; k++) {
                if (patArr[k] != txtArr[k]) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                result.add(i);
            }
            isSame = true;
        }

        return result;
    }

//    private static boolean check(int[] patArr, int[] txtArr) {
//        for (int k = 0; k < patArr.length; k++) {
//            if (patArr[k] != txtArr[k]) {
//                return false;
//            }
//        }
//        return true;
//    }
}
