package naweb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2 {
    /*
    "abcxyasdfasdfxyabc"	["abc","xy","asdf","asdf","xy","abc"]
    "abcxyqwertyxyabc"	["abc","xy","qwerty","xy","abc"]
    "abcabcabcabc"	["abc","abc","abc","abc"]
    "llttaattll"	["l","l","t","t","a","a","t","t","l","l"]
    "zzzzzz"	["z","z","z","z","z","z"]
    "abcdef"	["abcdef"]
     */
    public static void main(String[] args) {
        String p1 = "abcxyasdfasdfxyabc";
        String p2 = "abcxyqwertyxyabc";
        String p3 = "abcabcabcabc";
        String p4 = "llttaattll";
        String p5 = "zzzzzz";
        String p6 = "abcdef";

        System.out.println(Arrays.toString(solution(p1)));
        System.out.println(Arrays.toString(solution(p2)));
        System.out.println(Arrays.toString(solution(p3)));
        System.out.println(Arrays.toString(solution(p4)));
        System.out.println(Arrays.toString(solution(p5)));
        System.out.println(Arrays.toString(solution(p6)));
    }

    private static String[] solution(String s) {

        List<String> result1 = new ArrayList<>();
        List<String> result2 = new ArrayList<>();
        int firstIdx = 0;
        int endIdx = s.length() - 1;
        int endLastIdx = 1;

        int centerStart = 0;
        int centerEnd = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            String start = s.substring(firstIdx, i + 1);
            String end = s.substring(endIdx - i, endIdx - i + endLastIdx);

            if (start.equals(end)) {
                result1.add(start);
                result2.add(end);
                firstIdx = i + 1;
                endLastIdx = 0;
                centerStart = firstIdx;
                centerEnd = endIdx - i;
            }
            endLastIdx++;
        }

        if (centerStart != centerEnd) {
            result1.add(s.substring(centerStart, centerEnd));
        }

        for (int i = result2.size() - 1; i >= 0; i--) {
            result1.add(result2.get(i));
        }

        String[] array = new String[result1.size()];
        for (int i = 0; i < result1.size(); i++) {
            array[i] = result1.get(i);
        }
        return array;
    }
}
