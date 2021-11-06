package codingtest.navfi.n03;

import java.util.Arrays;

public class P3 {
    public static void main(String[] args) {
        int[] A = new int[]{3, 2, 1};
        int[] B = new int[]{3, 2, 5, 4, 2, 2, 0, 0, 0};

        int[] A1 = new int[]{2, 1};
        int[] B1 = new int[]{3, 3};

        System.out.println(solution(A, B));
        System.out.println(solution(A1, B1));
    }

    private static int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0;
        for (int k = 0; k < n; k++) {
            while (i < m - 1 && B[i] < A[k]) {      // 1
                i += 1;
            }

            if (A[k] == B[i]) {
                return A[k];
            }
        }
        return -1;
    }
}
