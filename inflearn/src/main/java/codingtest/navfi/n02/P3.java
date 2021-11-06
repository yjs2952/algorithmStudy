package codingtest.navfi.n02;

import java.util.ArrayList;
import java.util.List;

public class P3 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"co", "dil", "ity"}));
        System.out.println(solution(new String[]{"abc", "yyy", "def", "csv"}));
        System.out.println(solution(new String[]{"potato", "kayak", "banana", "racecar"}));
        System.out.println(solution(new String[]{"eva", "jqw", "tyn", "jan"}));
    }

    private static int solution(String[] A) {

        int result = 0;
        List<String> list = new ArrayList<>();
        for (String str : A) {
            if (hasSameChar(str)) {
                continue;
            }
            list.add(str);
        }

        for (String str1 : list) {
            int maxLength = str1.length();
            StringBuilder sb = new StringBuilder(str1);
            for (String str2 : list) {
                if (sb.toString().equals(str2) || hasSameChar(sb.toString(), str2)) {
                    continue;
                }
                sb.append(str2);
                maxLength += str2.length();
            }
            result = Math.max(result, maxLength);
        }
        return result == 0 ? -1 : result;
    }

    private static boolean hasSameChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            String sub = str.substring(i, i + 1);
            String subString = str.replaceFirst(sub, "");

            if (subString.contains(sub)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasSameChar(String str1, String str2) {
        for (char c : str1.toCharArray()) {
            if (str2.indexOf(c) >= 0) return true;
        }

        for (char c : str2.toCharArray()) {
            if (str1.indexOf(c) >= 0) return true;
        }
        return false;
    }
}
