package inflearn.sort_searching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _05MeetingRoom2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{6, 10}, {1, 3}}));
        System.out.println(solution(new int[][]{{5, 10}, {16, 20}, {0, 30}}));
        System.out.println(solution(new int[][]{{5, 11}, {5, 10}, {16, 20}}));
        System.out.println(solution(new int[][]{{5, 10}, {5, 11}}));
        System.out.println(solution(new int[][]{{5, 6}, {5, 7}}));
        System.out.println(solution(new int[][]{{5, 7}, {5, 6}}));
        System.out.println(solution(new int[][]{{1, 4}, {4, 5}, {4, 6}}));
        System.out.println(solution(new int[][]{{5, 10}, {5, 11}, {16, 20}, {19, 21}}));
    }

    private static int solution(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        for (int[] interval : intervals) {
            if (!queue.isEmpty()) {
                if (queue.peek()[1] <= interval[0]) {
                    queue.poll();
                }
            }
            queue.offer(interval);
        }
        return queue.size();
    }
}
