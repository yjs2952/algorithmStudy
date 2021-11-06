package codingtest.six;

public class P1 {
    public static void main(String[] args) {
        int[] estimates1 = {5, 1, 9, 8, 10, 5};
        int k1 = 3;

        int[] estimates2 = {10, 1, 10, 1, 1, 4, 3, 10};
        int k2 = 6;

        System.out.println(solution(estimates1, k1));
        System.out.println(solution(estimates2, k2));
    }

    private static int solution(int[] estimates, int k) {
        int first = 0;
        int end = estimates.length - 1;
        int max = 0;

        for (int i = 0; i < estimates.length / 2; i++) {
            int leftSum = 0;
            int rightSum = 0;

            if (first < estimates.length - k  && end >= k) {
                for (int j = first; j < first + k; j++) {
                    leftSum += estimates[j];
                }

                for (int j = end; j >= end - k + 1; j--) {
                    rightSum += estimates[j];
                }

                if (leftSum > rightSum) {
                    max = Math.max(leftSum, max);
                } else {
                    max = Math.max(rightSum, max);
                }

                first++;
                end--;
            }
        }
        return max;
    }
}
