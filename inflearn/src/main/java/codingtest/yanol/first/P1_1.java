package codingtest.yanol.first;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class P1_1 {

    public static void main(String[] args) {
        int[] array = {1, 3, 6, 4, 1, 2};
        long start = System.currentTimeMillis();
        System.out.println(solution(array));
        long end = System.currentTimeMillis();
        System.out.println("performance : " + (end - start));
    }

    public static int solution(int[] A) {
        SortedSet<Integer> sortedSet = new TreeSet<>();
        for (int number : A) {
            sortedSet.add(number);
        }

        List<Integer> list = new ArrayList<>(sortedSet);

        int index = getIndex(list);

        if (index == 0 && list.get(0) < 0) {
            return 1;
        }

        int result = 1;

        for (int i = index; i < list.size(); i++) {

            if (list.get(i) != result) {
                return result;
            } else {
                result++;
            }
        }

        return result;
    }

    private static int getIndex(List<Integer> list) {
        int index = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 0) {
                index = i;
                break;
            }
        }
        return index;
    }
}
