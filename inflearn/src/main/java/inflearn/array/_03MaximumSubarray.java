package inflearn.array;

public class _03MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solution(new int[]{5, 4, -1, 7, 8}));
        System.out.println(solution(new int[]{-10, -20, -30, 10}));
    }

    private static int solution(int[] nums) {
        int currentMax = nums[0];
        int allMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            allMax = Math.max(allMax, currentMax);
        }

        return allMax;
    }
}
