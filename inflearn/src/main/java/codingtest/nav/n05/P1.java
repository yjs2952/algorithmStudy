package codingtest.nav.n05;

public class P1 {
    public static void main(String[] args) {
        int[] A1 = {0, 1, 1, 1, 0, 1, 1, 1, 0, 1};
        int[] A2 = {0, 0};
        int[] A3 = {0, 1, 0, 0, 1};

        System.out.println(solution(A1));
        System.out.println(solution(A2));
        System.out.println(solution(A3));
    }

    private static int solution(int[] A) {
        int n = A.length;
        int i = n - 1;
        int result = -1;
        int k = 0, maximal = 0;

        while (i > 0) {
            if (A[i] == 1) {
                k = k + 1;
                if (k >= maximal) {
                    maximal = k;
                    result = i;
                }
            } else {
                k = 0;
            }
            i = i - 1;
        }

//        if (A[i] == 1 && k + 1 > maximal) {
        if (A[i] == 1 && k + 1 >= maximal) {
            result = 0;
        }

        return result;
    }
}
