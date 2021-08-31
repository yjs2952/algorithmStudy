package inflearn.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _01TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 8, 11, 14}, 16)));
        System.out.println(Arrays.toString(solution(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(solution(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(solution(new int[]{3, 3}, 6)));
    }

    private static int[] solution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;

        for (int num : nums) {
            if (map.containsKey(target - num)) {
                return new int[]{map.get(target - num), index};
            } else {
                map.put(num, index);
            }
            index++;
        }
        return null;
    }
}
