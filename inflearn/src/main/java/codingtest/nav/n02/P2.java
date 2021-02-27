package codingtest.nav.n02;

import java.util.Arrays;

public class P2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{-6, -91, 1011, -100, 84, -22, 0, 1, 473}));
    }

    private static int solution(int[] A) {
        return Arrays.stream(A)
                .filter(number -> number > -10 && number < 10)
                .max()
                .getAsInt();
    }
}
