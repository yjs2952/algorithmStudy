package problem_11_to_20;

import java.util.ArrayList;
import java.util.List;

public class _16SpiralMatrix {

    /**
     * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order
     */
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(solve(matrix));
        System.out.println(solve(matrix2));
    }

    public static List<Integer> solve(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // right
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;

            // down
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            // left
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            // up
            if (colStart <= colEnd) {
//                if (rowStart <= rowEnd) {
                    for (int i = rowEnd; i >= rowStart; i--) {
                        result.add(matrix[i][colStart]);
                    }
//                }
            }
            colStart++;
        }

        return result;
    }
}
