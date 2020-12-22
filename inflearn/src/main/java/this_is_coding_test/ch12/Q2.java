package this_is_coding_test.ch12;

import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        String input = "K1KA5CB7";
        String input1 = "AJKDLSI412K4JSJ9D";

        System.out.println(solution(input));
        System.out.println(solution(input1));
    }

    private static String solution(String input) {
        String[] split = input.split("");
        Arrays.sort(split);
        input = String.join("", split);

        StringBuilder sb = new StringBuilder(input);

        int length = input.length();
        int sum = 0;

        for (int i = 0; i < length; i++) {
            char letter = input.charAt(i);
            if (letter >= '0' && letter <= '9') {
                sum += Character.digit(letter, 10);
                sb.deleteCharAt(i);
            }
        }

        sb.append(sum);
        return sb.toString();
    }
}
