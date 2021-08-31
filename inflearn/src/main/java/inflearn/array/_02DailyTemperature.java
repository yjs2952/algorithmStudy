package inflearn.array;

import java.util.Arrays;
import java.util.Stack;

public class _02DailyTemperature {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(solution(new int[]{30, 40, 50, 60})));
    }

    private static int[] solution(int[] numbs) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[numbs.length];

        for (int i = 0; i < numbs.length; i++) {
            while (!stack.isEmpty() && numbs[stack.peek()] < numbs[i]) {
                Integer index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        System.out.println(stack);
        return result;
    }
}
