package codingtest.coup.second;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P2 {

    public static void main(String[] args) {
        long n = 6;
        long n1 = 21;


        System.out.println(Arrays.toString(solution(n)));
        System.out.println(Arrays.toString(solution(n1)));
    }

    private static long[] solution(long N) {
        Queue<Long> queue = new PriorityQueue<>(Comparator.comparingLong(o -> o));

        for (int i = 2; i <= Math.sqrt(N); i++) {
            while (N % i == 0) {
                queue.add((long) i);
                if (queue.size() > 1) {
                    break;
                }
                N /= i;
            }
            if (queue.size() > 1) {
                break;
            }
        }

        if (N != 1) {
            queue.add(N);
        }

        if (queue.size() == 2) {
            Long first = queue.poll();
            Long second = queue.poll();

            if (first.equals(second)) {
                return new long[]{-1, -1};
            } else {
                return new long[]{first, second};
            }
        } else {
            return new long[]{-1, -1};
        }
    }
}
