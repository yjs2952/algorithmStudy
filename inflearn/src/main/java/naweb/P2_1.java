package naweb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2_1 {
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

        List<String> result = new ArrayList<>();

        int firstIdx = 0;
        int endIdx = s.length() - 1;
        String start = "";
        String end = "";
        int cnt = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            start = s.substring(firstIdx, i + 1);
            end = s.substring(endIdx - i, endIdx + 1);
            if (start.length() != end.length()) {
                end = s.substring(endIdx - cnt, endIdx + 1);
                cnt++;
            }
            if (start.equals(end)) {
                result.add(start);
                result.add(end);

                firstIdx = i + 1;
                endIdx = endIdx - end.length();
                cnt = 0;
            }
        }
        String[] array = new String[result.size()];

        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        return array;
    }
}
