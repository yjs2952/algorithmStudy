package codingtest.elevenstreet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 9, 7, 11);
        System.out.println(findMaxSum(list));
        System.out.println(findMaxSum2(list));
    }

    public static int findMaxSum(List<Integer> list) {
        long start = System.nanoTime();
        int first, second;
        if (list.get(0) > list.get(1)) {
            first = list.get(0);
            second = list.get(1);
        } else {
            first = list.get(1);
            second = list.get(0);
        }

        for (int i = 2; i < list.size(); i++) {
            if (list.get(i) > first) {
                second = first;
                first = list.get(i);
            } else if (list.get(i) > second && list.get(i) != first)
                second = list.get(i);
        }
        long end = System.nanoTime();
        System.out.println("performance : " + (end - start));
        return (first + second);
    }

    public static int findMaxSum2(List<Integer> list) {
        long start = System.nanoTime();
        list.sort(Comparator.reverseOrder());
        long end = System.nanoTime();
        System.out.println("performance : " + (end - start));
        return list.get(0) + list.get(1);
    }
}
