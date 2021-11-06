package codingtest.navfi.n01;

import java.util.Arrays;
import java.util.Random;

public class Q1_1 {
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

        int[] result = {first, second};

        if (first % 10 == 0 || second % 10 == 0) {
            for (int i = 0; i < result.length; i++) {
                if (result[i] % 10 == 0) {
                    if (result[result.length - 1 - i] > 1) {
                        result[i] += 1;
                        result[result.length - 1 - i] -= 1;
                        break;
                    } else {
                        result[i] -= 1;
                        result[result.length - 1 - i] += 1;
                        break;
                    }
                }
            }
        }

        return result;
    }
}
