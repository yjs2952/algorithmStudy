package this_is_coding_test.ch11;

import java.util.Arrays;

public class Q01 {

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 2, 2};
        System.out.println(solution(array));
    }

    private static int solution(int[] array) {
        Arrays.sort(array);

        int result = 0;
        int count = 0;
        for (int number : array) {
            count++;
            if (count >= number) {
                result++;
                count = 0;
            }
        }
        return result;
    }
}
