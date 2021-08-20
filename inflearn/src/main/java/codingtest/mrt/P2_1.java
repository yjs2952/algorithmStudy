package codingtest.mrt;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P2_1 {
    public static void main(String[] args) {
        String input1 = "{[]}";
        String input2 = "()[]{}";
        String input3 = "()((({}})({}[]]";
        String input4 = "(]";

        System.out.println(printValidationResult(input1));
        System.out.println(printValidationResult(input2));
        System.out.println(printValidationResult(input3));
        System.out.println(printValidationResult(input4));
    }

    private static final Map<Character, Character> map = new HashMap<>();

    static {
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
    }

    public static String printValidationResult(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : charArray) {
            if (map.containsKey(c)) {
                if (!stack.empty() && stack.peek().equals(map.get(c))) {
                    stack.pop();
                } else {
                    return "False";
                }
            } else {
                stack.push(c);
            }
        }

        return "True";
    }
}
