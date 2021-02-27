package codingtest.nav.n04;

import java.util.Arrays;

public class P3 {
    public static void main(String[] args) {
// -6, -91, 1011, -100, 84, -22, 0, 1, 473
//        System.out.println(solution());
    }

    public static int solution(int[] A) {
        return Arrays.stream(A)
                .filter(number -> number > -10 && number < 10)
                .max()
                .getAsInt();
    }
}
