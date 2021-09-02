package codingtest.yogi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 1}));
        System.out.println(solution(new int[]{1, 2, 4, 4}));
        System.out.println(solution(new int[]{1, 2, 4}));
        System.out.println(solution(new int[]{6, 2, 3, 5, 6, 3}));
    }

    private static int solution(int[] A) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= A.length; i++) {
            list.add(i);
        }

        int index = 0;
        for (int num : A) {
            if (list.contains(num)) {
                A[index] = 0;
                list.remove((Integer) num);
            }
            index++;
        }

        Arrays.sort(A);
        Collections.sort(list);

        index = A.length - list.size();
        int result = 0;
        for (Integer num : list) {
            result += Math.abs(num - A[index++]);
        }
        return result;
    }
}
