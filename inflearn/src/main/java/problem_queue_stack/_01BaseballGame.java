package problem_queue_stack;

import java.util.Stack;

public class _01BaseballGame {
    public static void main(String[] args) {
        String[] strs = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(strs));
    }

    public static int calPoints(String[] ops) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (String op : ops) {
            switch (op) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "+":
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y);
                    stack.push(x);
                    stack.push(x + y);
                    break;
                default:
                    Integer num = Integer.valueOf(op);
                    stack.push(num);
            }
        }

        while (!stack.empty()) {
            result += stack.pop();
        }

        return result;
    }

}
