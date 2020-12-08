package codingtest.coup;

import java.util.*;

public class P1 {
    public static void main(String[] args) {
        int[] input1 = {2, 1, 3, 3};
        int[] input2 = {3, 4, 4, 2, 5, 2, 5, 5};
        int[] input3 = {3, 5, 3, 5, 7, 5, 7};

        System.out.println(Arrays.toString(solution(input1)));
        System.out.println(Arrays.toString(solution(input2)));
        System.out.println(Arrays.toString(solution(input3)));
    }

    public static int[] solution(int[] arr) {
        if (arr == null || arr.length <= 0) return new int[] {-1};

        Set<Integer> singleNums = new TreeSet<>();
        Set<Integer> duplNums = new HashSet<>();
        for (int i : arr) {
            if (duplNums.contains(i)) {
                singleNums.remove(i);
                continue;
            }
            if (singleNums.contains(i)) {
                singleNums.remove(i);
                duplNums.add(i);
                continue;
            }
            if (!duplNums.contains(i)) {
                singleNums.add(i);
            }
        }
        if (singleNums.size() == 0) {
            return new int[]{-1};
        }
        int[] answer = new int[singleNums.size()];

        Iterator<Integer> iterator = singleNums.iterator();

        for (int i = 0; i < answer.length; i++) {
            answer[i] = iterator.next();
        }

        return answer;
    }
}
