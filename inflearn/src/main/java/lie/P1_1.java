package lie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class P1_1 {

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

    public static int solution(String string) {
        final Set<String> openBracket = new HashSet<>(Arrays.asList("(", "[", "{", "<"));
        final Set<String> closeBracket = new HashSet<>(Arrays.asList(")", "]", "}", ">"));
        final Stack<String> openBrackets = new Stack<>();
        final Stack<String> tmpBrackets = new Stack<>();
        int answer = 0;
        final String[] split = string.split("");
        for (String s : split) {
            if (openBracket.contains(s)) {
                openBrackets.push(s);
                continue;
            }
            if (closeBracket.contains(s)) {
                if (hasPair(openBrackets, tmpBrackets, s)) {
                    answer++;
                } else {
                    return -1;
                }
            }
        }
        return answer;
    }
    private static boolean hasPair(Stack<String> openBrackets, Stack<String> tmpBrackets, String close) {
        while (!openBrackets.empty()) {
            final String pop = openBrackets.pop();
            if (isProperPair(pop, close)) {
                rollbackOpenBrackets(openBrackets, tmpBrackets);
                return true;
            }
            tmpBrackets.push(pop);
        }
        return false;
    }
    private static void rollbackOpenBrackets(Stack<String> openBrackets, Stack<String> tmpBrackets) {
        while (!tmpBrackets.empty()) {
            openBrackets.push(tmpBrackets.pop());
        }
    }
    private static boolean isProperPair(String pop, String close) {
        return pop.equals("(") && close.equals(")") ||
                pop.equals("[") && close.equals("]") ||
                pop.equals("{") && close.equals("}") ||
                pop.equals("<") && close.equals(">");
    }
}
