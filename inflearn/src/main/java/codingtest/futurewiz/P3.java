package codingtest.futurewiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class P3 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, 1, 4, 5}));
        System.out.println(solution(new int[]{20, 10, 10, 20}));
        System.out.println(solution(new int[]{103, 101, 103, 103, 101, 102, 100, 100, 101, 104}));
    }

    private static int solution(int[] p) {
        Arrays.sort(p);
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        int result = 0;

        for (int i : p) {
            list.add(i);
        }

        while (!list.isEmpty()) {
            stack.push(list.get(0));

            int index = 0;
            while (!stack.isEmpty() && index++ < p.length) {
                if (stack.peek() < list.get(index)) {
                    stack.push(list.get(index));
                    list.remove(index);
                }
            }
            list.remove(0);
            result += stack.size() - 1;
            stack.clear();
        }

        return result + 1;
    }
}
