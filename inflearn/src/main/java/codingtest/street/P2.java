package codingtest.street;

public class P2 {
    public static void main(String[] args) {
        int[] A1 = {1, 1, 2, 3, 3};
        int[] A2 = {1, 1, 3};
        int[] A3 = {0, 1, 2};

        System.out.println(solution(A1, 3));
        System.out.println(solution(A2, 2));
        System.out.println(solution(A3, 2));
    }

    private static boolean solution(int[] A, int K) {
        int n = A.length;

        for (int i = 0; i < n - 1; i++) {
            if (A[i] + 1 < A[i + 1]) {
                return false;
            }
        }

//        if (A[0] != 1 && A[n - 1] != K) {
        if (A[0] != 1 || A[n - 1] != K) {
            return false;
        } else {
            return true;
        }
    }
}
