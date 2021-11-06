package codingtest.navfi.n04;

import java.util.Arrays;

public class P1 {
    public static void main(String[] args) {
        int[] p = {1, 4, 1};
        int[] s = {1, 5, 1};

        int[] p1 = {4, 4, 2, 4};
        int[] s1 = {5, 5, 2, 5};

        int[] p2 = {2, 3, 4, 2};
        int[] s2 = {2, 5, 7, 2};

        System.out.println(solution(p, s));
        System.out.println(solution(p1, s1));
        System.out.println(solution(p2, s2));
    }

    private static int solution(int[] P, int[] S) {
        int result = P.length;
        int remainSeats = 0;

        for (int i = 0; i < P.length; i++) {
            remainSeats += (S[i] - P[i]);
        }

        Arrays.sort(P);

        for (int person : P) {
            if (remainSeats - person >= 0) {
                result--;
                remainSeats -= person;
            } else {
                break;
            }
        }
        return result;
    }
}
