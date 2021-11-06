package codingtest.yanol.first;

import java.util.HashSet;
import java.util.Set;

public class P1_1 {

    public static void main(String[] args) {
        int[] array = {1, 3, 6, 4, 1, 2};
        System.out.println(solution(array));
        System.out.println(solution(new int[]{1, 2, 3}));
        System.out.println(solution(new int[]{-1, -3}));
    }

    public static int solution(int[] A) {
        int N = A.length;
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            if (a > 0) {
                set.add(a);
            }
        }
        for (int i = 1; i <= N + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }
}
