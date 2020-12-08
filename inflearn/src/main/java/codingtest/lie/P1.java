package codingtest.lie;

import java.util.Stack;

public class P1 {

    public static void main(String[] args) {
        String input1 = "Hello, world!";
        String input2 = "line [plus]";
        String input3 = "if (Count of eggs is 4.) {Buy milk.}";
        String input4 = ">_<";

        System.out.println(solution(input1));
        System.out.println(solution(input2));
        System.out.println(solution(input3));
        System.out.println(solution(input4));
    }

    public static int solution(String inputString) {

        if (inputString == null || inputString.replaceAll(" ", "").length() < 1) return 0;

        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{' || ch == '<') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}' || ch == '>') {
                if (stack.empty()) {
                    return -1;
                } else {
                    answer++;
                }
            }
        }

        return answer;
    }
}
