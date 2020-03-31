package coup;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P2 {

    public static void main(String[] args) {
        int[][] p = {{1, 3}, {3, 1}, {3, 5}, {2, 5}, {5, 3}};
        System.out.println(solution(p));
    }

    public static int solution(int [][] p)
    {
        if(p == null || p.length <= 0) return 0;
        int answer = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] ints : p) {
            if (map.containsKey(ints[0])) {
                map.get(ints[0]).add(ints[1]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(ints[1]);
                map.put(ints[0], set);
            }
            if (map.containsKey(ints[1]) && map.get(ints[1]).contains(ints[0])) {
                answer++;
            }
        }
        return answer;
    }
}
