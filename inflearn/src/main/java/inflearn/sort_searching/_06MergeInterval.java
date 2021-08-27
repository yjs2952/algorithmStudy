package inflearn.sort_searching;

import java.util.*;

public class _06MergeInterval {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(new int[][]{{1, 4}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(solution(new int[][]{{1, 5}, {5, 6}})));

        System.out.println(Arrays.deepToString(solution(new int[][]{{6, 10}, {1, 3}})));
        System.out.println(Arrays.deepToString(solution(new int[][]{{5, 10}, {16, 20}, {0, 30}})));
        System.out.println(Arrays.deepToString(solution(new int[][]{{5, 11}, {5, 10}, {16, 20}})));
        System.out.println(Arrays.deepToString(solution(new int[][]{{5, 10}, {5, 11}})));
        System.out.println(Arrays.deepToString(solution(new int[][]{{5, 6}, {5, 7}})));
        System.out.println(Arrays.deepToString(solution(new int[][]{{5, 7}, {5, 6}})));
        System.out.println(Arrays.deepToString(solution(new int[][]{{1, 4}, {4, 5}, {4, 6}})));
        System.out.println(Arrays.deepToString(solution(new int[][]{{5, 10}, {5, 11}, {16, 20}, {19, 21}})));
    }

    private static int[][] solution(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();

        for (int[] interval : intervals) {
            if (!list.isEmpty()) {
                int[] peek = list.get(list.size() - 1);

                if (peek[1] >= interval[0]) {
                    if (peek[1] < interval[1]) {
                        peek[1] = interval[1];
                    }
                    continue;
                }
            }
            list.add(interval);
        }

        return list.toArray(new int[list.size()][]);
    }

    private static int[][] solution2(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0)
            return res.toArray(new int[0][]);

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] interval : intervals) {
            if (end >= interval[0]) {
                end = Math.max(end, interval[1]);//6
            } else {
                res.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }

        }

        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);
    }

//    private static Comparator<int[]> comp() {
//        return (o1, o2) -> {
//            if (o1[0] > o2[0]) {
//                return 1;
//            } else if (o1[0] == o2[0]) {
//                if (o1[1] > o2[1]) {
//                    return 1;
//                }
//                return 0;
//            }
//            return -1;
//        };
//    }
}
