package this_is_coding_test.ch12;

import java.util.Scanner;

public class Q01 {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        String score = SCANNER.nextLine();
//        String score = "123402";
//        String score1 = "7755";
//        String score2 = "10";
//        String score3 = "99999999";

        System.out.println(solution(score));
//        System.out.println(solution(score1));
//        System.out.println(solution(score2));
//        System.out.println(solution(score3));
    }

    private static String solution(String score) {
        int mid = score.length() / 2;

        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < mid; i++) {
            leftSum += Integer.parseInt(score.substring(i, i + 1));
            rightSum += Integer.parseInt(score.substring(i + mid, i + mid + 1));
        }

        if (leftSum == rightSum) {
            return "LUCKY";
        }

        return "READY";
    }
}
