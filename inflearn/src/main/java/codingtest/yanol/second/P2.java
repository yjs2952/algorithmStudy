package codingtest.yanol.second;

import java.util.HashMap;
import java.util.Map;

public class P2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0, 3, 4, 3, 0, 2, 2, 3, 0, 0}));
        System.out.println(solution(new int[]{4, 2, 0}));
        System.out.println(solution(new int[]{4, 4, 3, 3, 1, 0}));
    }

    private static int solution(int[] ranks) {
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int rank : ranks) {
            map.put(rank, map.getOrDefault(rank, 0) + 1);
        }

        for (int rank : map.keySet()) {
            int superior = map.getOrDefault(rank + 1, 0);

            if (superior > 0) {
                result += map.get(rank);
            }
        }
        return result;
    }
}
