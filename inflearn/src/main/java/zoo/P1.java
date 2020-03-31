package zoo;

import java.util.HashMap;
import java.util.Map;

public class P1 {
    public static void main(String[] args) {
        int[] input1 = {3, 8, 2, 3, 3, 2};
        int[] input2 = {7, 1, 2, 8, 2};
        int[] input3 = {3, 1, 4, 1, 5};
        int[] input4 = {5, 5, 5, 5, 5};

        System.out.println(solution(input1));
        System.out.println(solution(input2));
        System.out.println(solution(input3));
        System.out.println(solution(input4));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8

        int result = 0;

        if (A == null || A.length <= 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey().equals(entry.getValue())) {
                result = Math.max(result, entry.getKey());
            }
        }

        return result;
    }
}
