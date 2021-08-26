package inflearn.sort_searching;

import java.util.Arrays;
import java.util.Comparator;

public class _04MeetingRoom {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{5,10},{16,20}, {0,30}}));
        System.out.println(solution(new int[][]{{5,11}, {5,10}, {16,20}}));
        System.out.println(solution(new int[][]{{5,10}, {5,11}, {16,20}}));
        System.out.println(solution(new int[][]{{5,10}, {5,11}}));
        System.out.println(solution(new int[][]{{5,6}, {5,7}}));
        System.out.println(solution(new int[][]{{5,7}, {5,6}}));
        System.out.println(solution(new int[][]{{6,10},{1,3}}));
    }

    private static boolean solution(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }

        return true;
    }
}
