package codingtest.woowa.t1;

import java.util.HashSet;
import java.util.Set;

public class P3 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, -2, 5, -3}));
        System.out.println(solution(new int[]{1, 1, 2, -1, 2, -1}));
        System.out.println(solution(new int[]{1, 2, 3, -4}));
        System.out.println(solution(new int[]{1}));
        System.out.println(solution(new int[]{-1_000_000_000, -1_000_000_000}));
        System.out.println(solution(new int[]{1_000_000_000,-1_000_000_000}));
    }

    private static int solution(int[] A) {
        Set<Integer> positiveSet = new HashSet<>();
        Set<Integer> negativeSet = new HashSet<>();
        for (int integer : A) {
            if (integer > 0) {
                positiveSet.add(integer);
            } else {
                negativeSet.add(integer);
            }
        }

        int max = 0;
        for (int integer : negativeSet) {
            if (positiveSet.contains(-integer)) {
                max = Math.max(max, -integer);
            }
        }
        return max;
    }
}
