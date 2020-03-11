import java.util.Arrays;

public class MoveZeros {

    /**
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * Example:
     * Input: [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * Note:
     * You must do this in-place without making a copy of the array.
     * Minimize the total number of operations.
     */

    public static void main(String[] args) {
        int[] nums = {0, 3, 2, 0, 8, 5};
        System.out.println(Arrays.toString(result(nums)));
    }

    private static int[] result(int[] input){

        int length = input.length;
        int[] result = new int[length];
        int index = 0;


        for (int value : input) {
            if (value != 0) {
                result[index] = value;
                index++;
            }
        }

        for (int i = index; i < length; i++) {
            result[i] = 0;
        }
        return result;
    }
}
