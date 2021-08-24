package leetcode.easy.string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        String input1 = "III";
        String input2 = "IV";
        String input3 = "IX";
        String input4 = "LVIII";
        String input5 = "MCMXCIV";

        System.out.println(solution(input1));
        System.out.println(solution(input2));
        System.out.println(solution(input3));
        System.out.println(solution(input4));
        System.out.println(solution(input5));
    }

    private static final Map<Character, Integer> map = new HashMap<>();

    private static Map<Character, Integer> getInteger() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }

    private static int solution(String s) {
        Map<Character, Integer> map = getInteger();

        for (char c : s.toCharArray()) {
            int number = map.get(c);


        }
        return 0;
    }
}
