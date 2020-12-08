package codingtest.zoo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class P2 {
    public static void main(String[] args) {
        int[] input1 = {51, 71, 17, 42};
        int[] input2 = {42, 33, 60};
        int[] input3 = {51, 32, 43};

        System.out.println(solution(input1));
        System.out.println(solution(input2));
        System.out.println(solution(input3));
    }

    public static int solution(int[] A) {
        if (A == null || A.length <= 0)
            return -1;

        int answer = Integer.MIN_VALUE;
        Map<Integer, TreeSet<Integer>> digitSumAndOriginMap = new HashMap<>();
        for (int i : A) {
            int digitSum = getDigitSum(i);
            if (digitSumAndOriginMap.containsKey(digitSum)) {
                digitSumAndOriginMap.get(digitSum).add(i);
            } else {
                TreeSet<Integer> origins = new TreeSet<>(Comparator.reverseOrder());
                origins.add(i);
                digitSumAndOriginMap.put(digitSum, origins);
            }
        }
        boolean existSum = false;
        for (Map.Entry<Integer, TreeSet<Integer>> integerTreeSetEntry : digitSumAndOriginMap.entrySet()) {
            TreeSet<Integer> origins = integerTreeSetEntry.getValue();
            if (origins.size() < 2) {
                continue;
            }
            existSum = true;
            Integer first = origins.pollFirst();
            Integer second = origins.pollFirst();
            answer = Math.max(answer, first + second);
        }
        return existSum ? answer : -1;
    }
    private static int getDigitSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}
