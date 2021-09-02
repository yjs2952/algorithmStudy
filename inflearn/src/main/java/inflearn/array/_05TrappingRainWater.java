package inflearn.array;

public class _05TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(solution2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(solution2(new int[]{4, 2, 0, 3, 2, 5}));
    }

    private static int solution(int[] height) {
        int length = height.length;
        int[] left = new int[length];
        int[] right = new int[length];

        int max = 0;
        for (int i = 0; i < length; i++) {
            max = Math.max(max, height[i]);
            left[i] = max;
        }

        max = 0;
        for (int i = length - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            right[i] = max;
        }

        int result = 0;
        for (int i = 0; i < length; i++) {
            result += Math.min(left[i], right[i]) - height[i];

        }

        return result;
    }

    private static int solution2(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max)
                    left_max = height[left];
                else
                    ans += (left_max - height[left]);
                ++left;
            } else {
                if (height[right] >= right_max)
                    right_max = height[right];
                else
                    ans += (right_max - height[right]);
                --right;
            }
        }
        return ans;
    }
}
