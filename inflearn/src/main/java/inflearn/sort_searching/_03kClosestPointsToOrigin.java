package inflearn.sort_searching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _03kClosestPointsToOrigin {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[][]{{1, 3}, {-2, 2}}, 1)));
        System.out.println(Arrays.deepToString(solution(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
    }

    private static int[][] solution(int[][] points, int k) {
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> (o[0] * o[0] + o[1] * o[1])));
        for (int[] point : points) {
            queue.offer(point);
        }

        int[][] result = new int[k][];
        int index = 0;

        while (index < result.length) {
            result[index++] = queue.poll();
        }
//        for (int i = 0; i < result.length; i++) {
//            result[i] = queue.poll();
//        }
        return result;
    }
}
