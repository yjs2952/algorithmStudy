package problem_graph;

public class _01NumberOfIslandDFS {
    /**
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.
     * Example 1:
     * Input:
     * 11110
     * 11010
     * 11000
     * 00000
     * Output: 1
     * Example 2:
     * Input:
     * 11000
     * 11000
     * 00100
     * 00011
     * Output: 3
     */
    public static void main(String[] args) {
        char[][] input = {
                {'1', '1', '1', '0', '1'},
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '0', '0', '1'}
        };

        //11110
        //11010
        //11000
        //00000
        char[][] input2 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(numsIslands(input));
        System.out.println(numsIslands(input2));
    }

    public static int numsIslands(char[][] grid) {
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                char ch = grid[i][j];
                if (ch == '1') {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private static void dfs(char[][] grid, int i, int j) {
        int maxWidth = grid[0].length;
        int maxHeight = grid.length;

        if (i < 0 || i >= maxHeight || j < 0 || j >= maxWidth || grid[i][j] != '1') return;

        grid[i][j] = 'x';

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
