package codingtest.kkmo;

public class P3 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, -7, 3, -7, 3}));
        System.out.println(solution(new int[]{3, 2, 3, 2, 3}));
        System.out.println(solution(new int[]{7, 4, -2, 4, -2, 9}));
        System.out.println(solution(new int[]{7, -5, -5, -5, 7, -1, 7}));
        System.out.println(solution(new int[]{1, 2}));

    }

    private static int solution(int[] A) {
        int result = 2;

        if (A.length <= 2) {
            return A.length;
        }

        int sameCount = 2;

        for (int i = 2; i < A.length; i++) {
            if (A[i] == A[i - 2]) {
                sameCount += 1;
            } else {
                sameCount = 2;
            }
            result = Math.max(sameCount, result);
        }

        return result;
    }
}
