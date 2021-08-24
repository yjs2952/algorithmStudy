package inflearn.string;

import java.util.Arrays;

public class _04PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(solution(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(solution(new int[]{0, 0, 1})));
    }

    private static int[] solution(int[] k) {
        for (int i = k.length - 1; i >= 0; i--) {
            k[i]++;
            if (k[i] < 10) {
                return k;
            }

            k[i] = 0;
        }

        int[] newArray = new int[k.length + 1];
        newArray[0] = 1;
        return newArray;
    }
}
