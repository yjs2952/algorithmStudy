package problem_01_to_10;

import java.util.*;

public class _09KClosest {
    /**
     * We have a list of points on the plane. Find the K closest points to the origin (0, 0).
     * (Here, the distance between two points on a plane is the Euclidean distance.)
     * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
     * Example 1:
     * Input: points = [[1,3],[-2,2]], K = 1
     * Output: [[-2,2]]
     * Explanation:
     * The distance between (1, 3) and the origin is sqrt(10).
     * The distance between (-2, 2) and the origin is sqrt(8).
     * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
     * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
     */

    public static void main(String[] args) {
        List<List<Integer>> input = Arrays.asList(Arrays.asList(1,3), Arrays.asList(-2,2), Arrays.asList(-2,3));
        int k = 2;

        System.out.println("result : " + Arrays.deepToString(kClosest(input, k)));
    }

    public static int[][] kClosest(List<List<Integer>> list, int k) {

        if (list == null || list.size() <= 0) {
            return null;
        }

        int[][] result = new int[list.size()][];
        Queue<int[]> queue = new PriorityQueue<>(list.size(), Comparator.comparingInt(o -> o[0] * o[0] + o[1] * o[1]));

        for (List<Integer> integers : list) {
            queue.offer(new int[]{integers.get(0), integers.get(1)});
        }

        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }

        return result;
    }
}
