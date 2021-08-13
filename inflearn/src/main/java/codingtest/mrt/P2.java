package codingtest.mrt;

import java.util.Stack;

public class P2 {
    public static void main(String[] args) {
        String input1 = "{[]}";
        String input2 = "()[]{}";
        String input3 = "()((({}})({}[]]";
        String input4 = "(]";

//        System.out.println(printValidationResult(input1));
//        System.out.println(printValidationResult(input2));
        System.out.println(printValidationResult(input3));
        System.out.println(printValidationResult(input4));
    }

    public static String printValidationResult(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : charArray) {
            switch (c) {
                case '}':
                    if (!stack.empty() && stack.peek() == '{') {
                        stack.pop();
                    }
                    break;
                case ']':
                    if (!stack.empty() && stack.peek() == '[') {
                        stack.pop();
                    }
                    break;
                case ')':
                    if (!stack.empty() && stack.peek() == '(') {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(c);
                    break;
            }
        }

        return stack.empty() ? "True" : "False";
    }
}
