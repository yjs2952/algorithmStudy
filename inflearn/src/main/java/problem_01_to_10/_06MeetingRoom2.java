package problem_01_to_10;

import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _06MeetingRoom2 {

    /**
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
     * find the minimum number of conference rooms required.
     *
     * Input: [[0,30],[5,10],[15,20]]
     * Output: 2
     * Input: [[7,10],[2,4]]
     * Output: 1
     */
    public static void main(String[] args) {
        Interval[] input1 = {new Interval(0, 30), new Interval(5, 10), new Interval(15, 20), new Interval(25, 30)};
        Interval[] input2 = {new Interval(7, 10), new Interval(2, 4), new Interval(3, 6), new Interval(4, 5)};

        _06MeetingRoom2 m = new _06MeetingRoom2();

        System.out.println("output1 : " + m.solve(input1));
        System.out.println("output2 : " + m.solve(input2));
    }

    public int solve(Interval[] intervals) {
        if (intervals == null || intervals.length <= 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));

        Queue<Interval> queue = new PriorityQueue<>(intervals.length, Comparator.comparingInt(o -> o.end));

        queue.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            Interval before = queue.poll();
            if (before.end <= intervals[i].start) {
                before.end = intervals[i].end;
            } else {
                queue.offer(intervals[i]);
            }

            queue.offer(before);
        }

        System.out.println("queue : " + queue);
        return queue.size();
    }

    @ToString
    static class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
