package problem_01_to_10;

import java.util.Arrays;

public class _10PlusOne_2 {
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
        int[] input2 = {9, 9, 9};

        System.out.println("result1 : " + Arrays.toString(plusOne(input1)));
        System.out.println("result2 : " + Arrays.toString(plusOne(input2)));
    }

    public static int[] plusOne(int[] digits) {
        int[] result = null;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }

        if (digits[0] == 0) {
            result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }

        return digits;
    }
}
