package this_is_coding_test.ch03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _02_law_of_big_number {
    public static void main(String[] args) {
        String input = "5 8 3\n2 4 5 4 6";

        long start = System.nanoTime();
        System.out.println(solution(input));
        long end = System.nanoTime();

        System.out.println("성능 : " + (end - start));
    }

    private static int solution(String input) {
        String[] splits = input.split("\n");
        List<Integer> list1 = getIntegerList(splits[0]);
        List<Integer> list2 = getIntegerList(splits[1]);

        int n = list1.get(0);
        int m = list1.get(1);
        int k = list1.get(2);

        list2.sort(Collections.reverseOrder());

        int first = list1.get(0);
        int second = list1.get(1);

        int count = m / (k + 1) * k;
        count += m % (k + 1);

        int result = count * first;
        result += (m - count) * second;

        return result;
    }

    private static List<Integer> getIntegerList(String input) {
        String[] splits = input.split(" ");
        List<Integer> list = new ArrayList<>();
        for (String ch : splits) {
            list.add(Integer.parseInt(ch));
        }
        return list;
    }
}
