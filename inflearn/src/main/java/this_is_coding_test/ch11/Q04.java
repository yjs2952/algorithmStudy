package this_is_coding_test.ch11;

import java.util.Arrays;
import java.util.Scanner;

public class Q04 {
    public static void main(String[] args) {
//        int[] array = {3, 2, 1, 1, 9};
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] array = new int[num];

        for (int i = 0; i < num; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(solution(array));
    }

    private static int solution(int[] array) {
        Arrays.sort(array);
        int tartget = 1;

        for (int number : array) {
            if (tartget < number) {
                break;
            }
            tartget += number;
        }
        return tartget;
    }
}
