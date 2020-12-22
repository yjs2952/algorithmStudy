package this_is_coding_test.ch12;

import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        String input = "K1KA5CB7";
        String input1 = "AJKDLSI412K4JSJ9D";

        System.out.println(solution(input));
        System.out.println(solution(input1));
        System.out.println(solution2(input));
        System.out.println(solution2(input1));
    }

    private static String solution(String input) {
        String[] split = input.split("");
        Arrays.sort(split);
        input = String.join("", split);
        StringBuilder sb = new StringBuilder(input);

        int length = sb.length();
        int sum = 0;
        for (int i = 0; i < length; i++) {
            char letter = sb.charAt(i);
            if (Character.isDigit(letter)) {
                sum += Character.digit(letter, 10);
                sb.setCharAt(i, ' ');
            } else {
                break;
            }
        }


        if (sum > 0) sb.append(sum);

        return sb.toString().trim();
    }

    private static String solution2(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);

        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                sum += Character.digit(chars[i], 10);
                chars[i] = ' ';
            }
        }

        StringBuilder sb = new StringBuilder(String.valueOf(chars));
        sb.append(sum);
        return sb.toString().trim();
    }
}
