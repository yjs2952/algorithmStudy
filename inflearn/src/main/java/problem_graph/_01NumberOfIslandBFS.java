package problem_graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _01NumberOfIslandBFS {
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

                if (grid[i][j] == '1') {
                    result++;
                    bfs(grid, i, j);
                }
            }
        }
        System.out.println(Arrays.deepToString(grid));

        return result;
    }

    private static final int[][] POSITION = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private static void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] point = queue.poll();
            for (int k = 0; k < size; k++) {
                for (int[] pos : POSITION) {
                    int x = point[0] + pos[0];
                    int y = point[1] + pos[1];

                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
                        grid[x][y] = '0';
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }
}
