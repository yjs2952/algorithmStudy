package codingtest.woowa.t2;

import java.util.Arrays;
import java.util.Comparator;

public class P3 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{100, 3}, {200, 1}, {50, 2}}));
        System.out.println(solution(new int[][]{{2500, 3}, {700, 5}}));
    }

    private static int solution(int[][] money) {
        int sum = 0;
        Arrays.sort(money, Comparator.comparingInt(o -> o[0]));

        for (int[] ints : money) {
            sum += (ints[0] * ints[1]);
        }

        int halfSum = sum / 2;

        int first = 0;
        for (int[] ints : money) {
            int unit = ints[0];
            int count = ints[1];

            for (int i = 0; i < count; i++) {
                first += unit;

                if (first >= halfSum) {
                    int second = sum - first;
                    return first - second;
                }
            }
        }
        return 0;
    }
}
