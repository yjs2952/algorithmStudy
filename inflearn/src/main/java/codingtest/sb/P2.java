package codingtest.sb;

import java.util.PriorityQueue;

public class P2 {
    public static void main(String[] args) {
        System.out.println(solution(6, 1, 1));
//        System.out.println(solution(1, 3, 1));
//        System.out.println(solution(0, 1, 8));
//
//        System.out.println(solution(0, 3, 0));
    }

    private static String solution(int A, int B, int C) {
        int[] count = {A, B, C};
        char[] charArray = {'a', 'b', 'c'};
        String[] temp = {"aa", "bb", "cc"};

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> (count[o2] - count[o1]));

        if (A > 0) {
            queue.offer(0);
        }
        if (B > 0) {
            queue.offer(1);
        }
        if (C > 0) {
            queue.offer(2);
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int num1 = queue.poll();

            if (sb.length() >= 2 && sb.substring(sb.length() - 2).equals(temp[num1])) {
                if (queue.isEmpty()) {
                    return sb.toString();
                }

                int num2 = queue.poll();

                sb.append(charArray[num2]);
                count[num2]--;

                if (count[num2] > 0) {
                    queue.offer(num2);
                }

                queue.offer(num1);
            } else {
                sb.append(charArray[num1]);
                count[num1]--;

                if (count[num1] > 0) {
                    queue.offer(num1);
                }
            }
        }

        return sb.toString();
    }
}
