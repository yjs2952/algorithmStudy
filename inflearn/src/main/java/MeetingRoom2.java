import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoom2 {

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

        MeetingRoom2 m = new MeetingRoom2();

        System.out.println("output1 : " + m.solve(input1));
        System.out.println("output2 : " + m.solve(input2));
    }

    public int solve(Interval[] intervals) {
        if (intervals == null || intervals.length <= 0) return 0;

        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));

        Queue<Interval> queue = new PriorityQueue<>(intervals.length, Comparator.comparingInt(o -> o.end));

        queue.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            Interval interval = queue.poll();

            if (interval.end <= intervals[i].start) {
                interval.end = intervals[i].end;
            } else {

                // 회의룸이 하나 더 필요하다
                queue.offer(intervals[i]);
            }

            queue.offer(interval);
        }

        return queue.size();
    }

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
