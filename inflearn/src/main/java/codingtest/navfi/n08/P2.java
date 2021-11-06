package codingtest.navfi.n08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{3, 2, 4, 3}, 2, 4)));
        System.out.println(Arrays.toString(solution(new int[]{1, 5, 6}, 4, 3)));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4}, 4, 6)));
        System.out.println(Arrays.toString(solution(new int[]{6, 1}, 1, 1)));
        System.out.println(Arrays.toString(solution(new int[]{6, 1}, 1, 3)));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5, 6, 6}, 2, 4)));
    }

    private static int[] solution(int[] A, int F, int M) {
        int totalSum = (A.length + F) * M;

        int diceSum = 0;
        for (int num : A) {
            diceSum += num;
        }

        int remains = totalSum - diceSum;
        int maxDiceNum = 6;
        if (remains > F * maxDiceNum || remains < 0) {
            return new int[]{0};
        }

        List<Integer> list = new ArrayList<>();
        while (remains >= maxDiceNum) {
            list.add(maxDiceNum);
            remains -= maxDiceNum;
            F--;
        }

        if (remains > 0) {
            if (F == 1) {
                list.add(remains);
            } else {
                int oneCnt = 0;
                while (F > 1) {
                    list.add(1);
                    oneCnt++;
                    F--;
                }
                list.add(remains - oneCnt);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
