package codingtest.zb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[][] array = new int[length][3];

        for (int i = 0; i < length; i++) {
            String[] splits = br.readLine().split(" ");
            array[i][0] = Integer.parseInt(splits[0]);
            array[i][1] = Integer.parseInt(splits[1]);
            array[i][2] = Integer.parseInt(splits[2]);
        }

//        solution(new int[][]{{1, 3, 5}, {2, 2, 4}, {3, 5, 6}, {4, 7, 8}, {5, 7, 10}});
        solution1(array);
        solution2(array);
    }

    private static void solution1(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[2] == o2[2]) {
                return o1[1] - o2[1];
            }
            return o1[2] - o2[2];
        });

        int count = 0;
        int prevEndTime = 0;

        for (int[] interval : intervals) {
            if (prevEndTime <= interval[1]) {
                prevEndTime = interval[2];
                count++;
            }
        }

        System.out.println(count);
    }

    private static void solution2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        for (int[] interval : intervals) {
            if (!queue.isEmpty()) {
                if (queue.peek()[2] <= interval[1]) {
                    queue.poll();
                }
            }
            queue.offer(interval);
        }
        System.out.println(queue.size());
    }
}
