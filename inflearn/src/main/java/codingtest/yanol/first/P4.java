package codingtest.yanol.first;

import java.util.Stack;

public class P4 {

    public static void main(String[] args) {
        int[] array = {2, 4, 1, 6, 5, 9, 7};
        int[] array1 = {4, 3, 2, 6, 1};
        int[] array2 = {2, 1, 6, 4, 3, 7};
        int[] array3 = {2, 1, 0, 3};
        System.out.println(solution(array));
        System.out.println(solution(array1));
        System.out.println(solution(array2));
        System.out.println(solution(array3));
    }

    private static int solution(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= stack.peek()) {
                stack.push(array[i]);
            } else {
                int last = stack.pop();
                while ( stack.size() > 0 && array[i] < stack.peek()) {
                    stack.pop();
                }
                stack.push(last);
            }
        }
        return stack.size();
    }
}
