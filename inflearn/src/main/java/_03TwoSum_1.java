import java.util.Arrays;

public class _03TwoSum_1 {

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

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];

            if (temp <= 0) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (temp == nums[j]) {
                    result = new int[2];
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return result;
    }
}
