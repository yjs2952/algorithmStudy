package inflearn.sort_searching;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class _02KthLargestElementInAnArray {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(solution(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));

        System.out.println(solution2(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(solution2(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    private static int solution(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    private static int solution2(int[] nums, int k) {
        // heap
        Queue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}