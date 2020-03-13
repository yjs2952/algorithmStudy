import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval_2 {

    public static void main(String[] args) {
        List<Interval_2> input = Arrays.asList(new Interval_2(2, 6), new Interval_2(1, 7), new Interval_2(8, 10), new Interval_2(15, 18));

        MergeInterval_2 m = new MergeInterval_2();

        System.out.println(m.merge(input));
    }

    public List<Interval_2> merge(List<Interval_2> intervals) {

        if (intervals == null) return null;

        List<Interval_2> result = new ArrayList<>();

        intervals.sort(Comparator.comparingInt(o -> o.start));

        Interval_2 before = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            if (before.end >= intervals.get(i).start) {
                before.end = Math.max(before.end, intervals.get(i).end);
            } else {
                result.add(before);
                before = intervals.get(i);
            }
        }

        if (!result.contains(before)) {
            result.add(before);
        }

        return result;
    }
}

@ToString
class Interval_2 {
    int start;
    int end;

    Interval_2() {
        start = 0;
        end = 0;
    }
    Interval_2(int s, int e) {
        start = s;
        end = e;
    }
}
