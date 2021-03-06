package problem_01_to_10;

import java.util.Arrays;
import java.util.Stack;

public class _04DailyTemperature_2 {

    /**
     * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature.
     * If there is no future day for which this is possible, put 0 instead.
     * For example, given the list of temperatures
     * T = [73, 74, 75, 71, 69, 72, 76, 73],
     * your output should be [1, 1, 4, 2, 1, 1, 0, 0].
     * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
     */
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        System.out.println(Arrays.toString(solve(temperatures)));
    }

    private static int[] solve(int[] temperatures){
        int[] result = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();  //
                result[index] = i - index;  //
            }

            stack.push(i);  // 6
        }

        return result;
    }
}
