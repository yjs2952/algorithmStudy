package problem_graph;

public class _03MaxOfIsland {

    /**
     * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
     * You may assume all four edges of the grid are surrounded by water.
     * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
     * <p>
     * Example 1:
     * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     * [0,0,0,0,0,0,0,1,1,1,0,0,0],
     * [0,1,1,0,1,0,0,0,0,0,0,0,0],
     * [0,1,0,0,1,1,0,0,1,0,1,0,0],
     * [0,1,0,0,1,1,0,0,1,1,1,0,0],
     * [0,0,0,0,0,0,0,0,0,0,1,0,0],
     * [0,0,0,0,0,0,0,1,1,1,0,0,0],
     * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
     */

    public static void main(String[] args) {
        int[][] input1 = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        int[][] input2 = {
                {1, 1, 0, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1}
        };

        System.out.println(maxAreaOfIsland(input1));
        System.out.println(maxAreaOfIsland(input2));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result = Math.max(dfs(grid, i, j), result);
            }
        }
        return result;
    }

    public static int dfs(int[][] grid, int i, int j){

        int height = grid.length;
        int width = grid[0].length;

        if (i < 0 || i >= height || j < 0 || j >= width || grid[i][j] != 1 ) return 0;
        grid[i][j] = 0;
        return dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i , j - 1) + dfs(grid, i, j + 1) + 1;
    }
}
