package problem_01_to_10;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _05MergeInterval_1 {

    public static void main(String[] args) {
        List<Interval_1> input = Arrays.asList(new Interval_1(2, 6), new Interval_1(1, 3), new Interval_1(8, 10), new Interval_1(15, 18));

        _05MergeInterval_1 m = new _05MergeInterval_1();

        System.out.println(m.merge(input));
    }

//    Comparator<Interval_1> comp = new Comparator<Interval_1>() {
//        @Override
//        public int compare(Interval_1 o1, Interval_1 o2) {
//            return o1.start - o2.start;
//        }
//    };

    public List<Interval_1> merge(List<Interval_1> intervals) {

        if (intervals == null) return null;

        List<Interval_1> result = new ArrayList<>();

//        Collections.sort(intervals, comp);
//        Collections.sort(intervals, (o1, o2) -> o1.start - o2.start);
//        intervals.sort((o1, o2) -> o1.start - o2.start);

        intervals.sort(Comparator.comparingInt(o -> o.start));

        for (int i = 0; i < intervals.size(); i++) {

            int index = 0;
            for (int j = i + 1; j < intervals.size(); j++) {
                if (intervals.get(i).end >= intervals.get(j).start) {
                    index = j;
                }
            }

            if (index > 0) {
                result.add(new Interval_1(intervals.get(i).start, intervals.get(index).end));
                i = index;
            } else {
                result.add(new Interval_1(intervals.get(i).start, intervals.get(i).end));
            }
        }

        return result;
    }
}

@ToString
class Interval_1 {
    int start;
    int end;

    Interval_1() {
        start = 0;
        end = 0;
    }
    Interval_1(int s, int e) {
        start = s;
        end = e;
    }
}
