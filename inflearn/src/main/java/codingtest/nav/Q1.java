package codingtest.nav;

import java.util.Arrays;
import java.util.Random;

public class Q1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(12)));
        System.out.println(Arrays.toString(solution(104)));
        System.out.println(Arrays.toString(solution(200)));
        System.out.println(Arrays.toString(solution(3)));
        System.out.println(Arrays.toString(solution(2)));
        System.out.println(Arrays.toString(solution(500000)));
        System.out.println(Arrays.toString(solution(199)));
        System.out.println(Arrays.toString(solution(19)));
        System.out.println(Arrays.toString(solution(11)));
    }

    private static int[] solution(int n) {
        Random random = new Random();
        int first = random.nextInt(n - 1) + 1;
        int second = n - first;

        int[] result = new int[2];

        if (first % 10 != 0 && second % 10 != 0) {
            result[0] = first;
            result[1] = second;
        } else if (first % 10 == 0) {
            if (second > 1) {
                result[0] = first + 1;
                result[1] = second - 1;
            } else {
                result[0] = first - 1;
                result[1] = second + 1;
            }
        } else {
            if (first > 1) {
                result[0] = first - 1;
                result[1] = second + 1;
            } else {
                result[0] = first + 1;
                result[1] = second - 1;
            }

        }

        return result;
    }
}
