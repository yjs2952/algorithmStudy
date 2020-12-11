package codingtest.elevenstreet.before;

import java.util.Arrays;

public class P2 {
    public static void main(String[] args) {
        String[] array = {"abc", "bca", "dbe"};
        String[] array1 = {"zzzz", "ferz", "zdsr", "fgtd"};
        String[] array2 = {"gr", "sd", "rg"};
        String[] array3 = {"bdafg", "ceagi"};
        String[] array4 = {"bdafg"};

        System.out.println(Arrays.toString(solution(array)));
        System.out.println(Arrays.toString(solution(array1)));
        System.out.println(Arrays.toString(solution(array2)));
        System.out.println(Arrays.toString(solution(array3)));
        System.out.println(Arrays.toString(solution(array4)));
    }

    private static int[] solution(String[] array){
        if (array.length <= 1) {
            return new int[0];
        }

        for (int i = 0; i < array.length; i++) {
            String temp1 = array[i];

            for (int j = i + 1; j < array.length; j++) {
                String temp2 = array[j];
                for (int k = 0; k < temp1.length(); k++) {
                    if (temp1.charAt(k) == temp2.charAt(k)) {
                        return new int[]{i, j, k};
                    }
                }
            }
        }

        return new int[0];
    }
}
