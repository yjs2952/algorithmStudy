package problem_01_to_10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _03TwoSum_2 {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * Example:
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        
        System.out.println(Arrays.toString(solve(nums, target)));
    }

    private static int[] solve(int[] nums, int target){

        int[] result = null;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result = new int[2];
                result[0] = map.get(nums[i]);
                result[1] = i;
            } else {
                map.put(target - nums[i], i); // [16,0] [11,1] [7,2] [3, 3]
            }
        }

        return result;
    }
}
