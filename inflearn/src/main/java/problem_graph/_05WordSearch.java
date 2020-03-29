package problem_graph;

public class _05WordSearch {
    /**
     * Given a 2D board and a word, find if the word exists in the grid.
     * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
     * The same letter cell may not be used more than once.
     * Example: board = [
     * ['A','B','C','E'],
     * ['S','F','C','S'],
     * ['A','D','E','E'] ]
     * Given word = "ABCCED", return true.
     * Given word = "SEE", return true.
     * Given word = "ABCB", return false.
     */
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String input1 = "ABCCED";
        String input2 = "SEE";
        String input3 = "ABCB";

        System.out.println(solve(board, input1));
        System.out.println(solve(board, input2));
        System.out.println(solve(board, input3));
    }

    public static boolean solve(char[][] grid, String word) {

        int height = grid.length;
        int width = grid[0].length;

        boolean[][] visited = new boolean[height][width];

        for (int i = 0; i < height; i++) {

            for (int j = 0; j < width; j++) {
                if (dfs(grid, visited, 0, i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static final int[][] POINT = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private static boolean dfs(char[][] grid, boolean[][] visited, int start, int i, int j, String word) {
        if (start == word.length()) return true;
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return false;
        if (visited[i][j]) return false;
        if (grid[i][j] != word.charAt(start)) return false;

        visited[i][j] = true;

        for (int[] ints : POINT) {
            int x = i + ints[0];
            int y = j + ints[1];

            if (dfs(grid, visited, start + 1, x, y, word)) {
                return true;
            }
        }

        return false;
    }
}
