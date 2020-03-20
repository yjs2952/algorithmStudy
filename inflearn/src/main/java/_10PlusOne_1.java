import java.util.Arrays;
import java.util.Stack;

public class _10PlusOne_1 {
    /**
     * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
     * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
     * You may assume the integer does not contain any leading zero, except the number 0 itself.
     * Example 1:
     * Input: [1,2,3]
     * Output: [1,2,4]
     * Explanation: The array represents the integer 123.
     */
    public static void main(String[] args) {
        int[] input1 = {1, 2, 3};
        int[] input2 = {9, 8, 9};

        System.out.println("result1 : " + Arrays.toString(plusOne(input1)));
        System.out.println("result2 : " + Arrays.toString(plusOne(input2)));
    }

    public static int[] plusOne(int[] digits) {
        int[] result = null;
        Stack<Integer> stack = new Stack<>();
        boolean isNine = true;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (isNine) {
                if (digits[i] == 9) {
                    stack.add(0);
                } else {
                    stack.add(digits[i]+1);
                    isNine = false;
                }
            } else {
                stack.add(digits[i]);
            }
        }

        if (!stack.isEmpty() && stack.peek() == 0) {
            stack.add(1);
        }

        result = new int[stack.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }

        return result;
    }
}
