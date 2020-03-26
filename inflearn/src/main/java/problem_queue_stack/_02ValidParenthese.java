package problem_queue_stack;

import java.util.Stack;

public class _02ValidParenthese {

    public static void main(String[] args) {
        String input1 = "{[]}";
        String input2 = "()[]{}";
        String input3 = "([)]";
        String input4 = "(]";

        System.out.println(isValid(input1));
        System.out.println(isValid(input2));
        System.out.println(isValid(input3));
        System.out.println(isValid(input4));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char[] charArray = s.toCharArray();

        stack.push(charArray[0]);

        for (int i = 1; i < s.length(); i++) {
            switch (charArray[i]) {
                case '}' :
                    if (!stack.empty() && stack.peek() == '{') {
                        stack.pop();
                        break;
                    }
                case ']' :
                    if (!stack.empty() && stack.peek() == '[') {
                        stack.pop();
                        break;
                    }
                    break;
                case ')':
                    if (!stack.empty() && stack.peek() == '(') {
                        stack.pop();
                        break;
                    }
                    break;
                default:
                    stack.push(charArray[i]);
                    break;
            }
        }

        return stack.empty();
    }
}
