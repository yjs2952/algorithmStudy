package inflearn.array;

import java.util.ArrayList;
import java.util.List;

public class _06MissingRanges {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 3, 5, 50, 75}, 0, 99));
        System.out.println(solution(new int[]{2}, 0, 99));
    }

    private static List<String> solution(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();
        if (lower < nums[0]) {
            list.add(makeRange(lower, nums[0] - 1));
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 < nums[i]) {
                list.add(makeRange(nums[i - 1] + 1, nums[i] - 1));
            }
        }

        if (nums[nums.length - 1] < upper) {
            list.add(makeRange(nums[nums.length - 1] + 1, upper));
        }
        return list;
    }

    private static String makeRange(int lower, int num) {
        if (lower != num) {
            return lower + "->" + num;
        } else {
            return String.valueOf(lower);
        }
    }
}
