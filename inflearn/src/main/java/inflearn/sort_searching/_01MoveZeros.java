package inflearn.sort_searching;

public class _01MoveZeros {
    public static void main(String[] args) {
        solution(new int[]{0, 3, 2, 0, 8, 5});
    }

    private static void solution(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
