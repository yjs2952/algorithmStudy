package codingtest.yogi;

import java.util.*;

public class PP3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"ZASSETE", "S4Z537B", "7_ASZEYB"}, new String[]{"2455373", "425", "373", "378"})));
        System.out.println(Arrays.toString(solution(new String[]{"ZAZZ373"}, new String[]{"2422373", "5455373", "2455373"})));
    }

    static final Map<Character, Set<String>> map = new HashMap<>();

    static {
        map.put('0', new HashSet<>(Arrays.asList("O", "()")));
        map.put('1', new HashSet<>(Collections.singletonList("I")));
        map.put('2', new HashSet<>(Arrays.asList("Z", "S", "7_")));      //
        map.put('3', new HashSet<>(Arrays.asList("E", "B")));                   //
        map.put('4', new HashSet<>(Collections.singletonList("A")));
        map.put('5', new HashSet<>(Arrays.asList("Z", "S")));           //
        map.put('6', new HashSet<>(Arrays.asList("b", "G")));
        map.put('7', new HashSet<>(Arrays.asList("T", "Y")));
        map.put('8', new HashSet<>(Arrays.asList("B", "E3")));                  //
        map.put('9', new HashSet<>(Arrays.asList("g", "q")));
    }

    private static int[] solution(String[] numberStrs, String[] words) {
        int[] result = new int[words.length];
        int wordIndex = 0;
        for (String word : words) {
            char[] chars = word.toCharArray();

            for (String numberStr : numberStrs) {
                int start = 0;
                int end = chars.length;

                int match = 0;
                for (int i = 0; i < numberStr.length(); i++) {
                    for (String str : map.get(chars[i])) {
                        int index = numberStr.indexOf(str);
                        if (index == i) {
                            if (str.length() > 1) {
                                i++;
                            }
                            match++;
                        }
                    }
                }

                if (chars.length == match) {
                    result[wordIndex]++;
                }
                wordIndex++;
            }
        }
        return result;
    }
}
