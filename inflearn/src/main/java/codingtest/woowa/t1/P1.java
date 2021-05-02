package codingtest.woowa.t1;

public class P1 {
    public static void main(String[] args) {
        int upper = 3;
        int lower = 2;
        int[] col = {2, 1, 1, 0, 1};

        System.out.println(solution(upper, lower, col));
        System.out.println(solution(2, 3, new int[]{0, 0, 1, 1, 2}));
        System.out.println(solution(2, 5, new int[]{2, 1, 2, 2}));
        System.out.println(solution(2, 2, new int[]{2, 0, 2, 0}));

        System.out.println(solution(2, 4, new int[]{2, 2, 0, 2, 0}));
        System.out.println(solution(4, 2, new int[]{2, 2, 0, 2, 0}));
    }

    private static String solution(int U, int L, int[] C) {

        if (isImpossible(U, L, C)) {
            return "IMPOSSIBLE";
        }

        int[][] matrix = new int[2][C.length];
        int upperSum = 0;

        for (int i = 0; i < C.length; i++) {
            if (C[i] == 2) {
                matrix[0][i] = 1;
                matrix[1][i] = 1;
                upperSum++;
            }

            if (C[i] == 1) {
                matrix[0][i] = 1;
                upperSum++;
            }
        }

        swapUpperAndLower(U, C, matrix, upperSum);
        return createResult(matrix);
    }

    private static boolean isImpossible(int U, int L, int[] C) {
        int colSum = sumOfColSum(C);
        int numberOfTwo = numberOfTwo(C);

        return (colSum != (U + L)) ||
                U > C.length ||
                L > C.length ||
                numberOfTwo > U ||
                numberOfTwo > L;
    }

    private static int numberOfTwo(int[] C) {
        int sum = 0;
        for (int c : C) {
            if (c == 2) {
                sum++;
            }
        }
        return sum;
    }

    private static void swapUpperAndLower(int U, int[] C, int[][] matrix, int upperSum) {
        for (int i = 0; i < C.length; i++) {
            if (upperSum == U) {
                break;
            }

            if (C[i] == 1) {
                matrix[0][i] = 0;
                matrix[1][i] = 1;
                upperSum--;
            }
        }
    }

    private static int sumOfColSum(int[] C) {
        int sum = 0;
        for (int c : C) {
            sum += c;
        }
        return sum;
    }

    private static String createResult(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int[] m : matrix) {
            for (int number : m) {
                sb.append(number);
            }
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
