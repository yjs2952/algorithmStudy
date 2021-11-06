package codingtest.navfi.n01;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q3_1 {

    private static final List<Character> LETTERS = IntStream.range('a', 'z' + 1).mapToObj(letter -> (char) letter).collect(Collectors.toList());    // a ~ z 리스트
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        System.out.println(LETTERS);
        System.out.println(solution("asdf?asdf"));
        System.out.println(solution("rd?e?wg??"));
        System.out.println(solution("?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????"));
        System.out.println(solution("ab?ac?"));
        System.out.println(solution("?"));
        System.out.println(solution("??"));
    }

    private static String solution(String riddle) {
        StringBuilder sb = new StringBuilder(riddle);
        int riddleSize = sb.length();
        int lettersSize = LETTERS.size();
        for (int i = 0; i < riddleSize; i++) {
            if (sb.charAt(i) == '?') {

                if (riddleSize <= 1) {
                    sb.setCharAt(i, LETTERS.get(RANDOM.nextInt(lettersSize)));
                    break;
                }

                char next;
                char before;

                if (i == 0) {
                    next = sb.charAt(i + 1);
                    sb.setCharAt(i, getRandomLetterWithoutExceptLetters(next));
                } else if (i == riddleSize - 1) {
                    before = sb.charAt(i - 1);
                    sb.setCharAt(i, getRandomLetterWithoutExceptLetters(before));
                } else {
                    next = sb.charAt(i + 1);
                    before = sb.charAt(i - 1);
                    sb.setCharAt(i, getRandomLetterWithoutExceptLetters(before, next));
                }
            }
        }
        return sb.toString();
    }

    private static char getRandomLetterWithoutExceptLetters(Character ...exceptLetters) {
        for (Character letter : exceptLetters) {
            LETTERS.remove(letter);
        }

        int size = LETTERS.size();
        char result = LETTERS.get(RANDOM.nextInt(size));

        Collections.addAll(LETTERS, exceptLetters);
        return result;
    }
}
