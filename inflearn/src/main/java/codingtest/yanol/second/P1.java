package codingtest.yanol.second;

import java.util.Arrays;
import java.util.Random;

public class P1 {
    private final static Random RANDOM = new Random();

    public static void main(String[] args) {
        int n = 4;
        System.out.println(Arrays.toString(solution(n)));
    }

    private static int[]  solution(int N){
        int[] result = new int[N];

        if (N % 2 == 0) {
            for (int i = 0; i < N; i+=2) {
                int randomNumber = RANDOM.nextInt(Integer.MAX_VALUE);

                if (hasDuplicateNumber(result, randomNumber)) {
                    randomNumber = randomNumber / 2;
                }
                result[i] = randomNumber;
                result[i + 1] = -randomNumber;
            }
        } else {
            result[0] = 0;
            for (int i = 1; i < N; i += 2) {
                int randomNumber = RANDOM.nextInt(Integer.MAX_VALUE);
                if (hasDuplicateNumber(result, randomNumber)) {
                    randomNumber = randomNumber / 2;
                }
                result[i] = randomNumber;
                result[i + 1] = -randomNumber;
            }
        }

        return result;
    }

    private static boolean hasDuplicateNumber(int[] array, int number) {
        for (int num : array) {
            if (num == number) {
                return true;
            }
        }
        return false;
    }
}
