package problem_graph;

public class _06MazeDFS {

    /**
     * There is a ball in a maze with empty spaces and walls.
     * The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall.
     * When the ball stops, it could choose the next direction.
     * Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
     * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space.
     * You may assume that the borders of the maze are all walls.
     * The start and destination coordinates are represented by row and column indexes.
     * <p>
     * Example 1:
     * Input 1: a maze represented by a 2D array
     * 0 0 1 0 0
     * 0 0 0 0 0
     * 0 0 0 1 0
     * 1 1 0 1 1
     * 0 0 0 0 0
     * Input 2: start coordinate (rowStart, colStart) = (0, 4)
     * Input 3: destination coordinate (rowDest, colDest) = (4, 4)
     * Output: true
     */
    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = {0, 4};
//		int[] dest = {4,4};
        int[] dest = {3, 2};
        System.out.println(hasPath(maze, start, dest));
    }

    private static final int[][] point = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int m, n;

    private static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;

        boolean[][] visited = new boolean[m][n];

        return dfs(maze, start, destination, visited);
    }

    private static boolean dfs(int[][] maze, int[] start, int[] dest, boolean[][] visited) {
        if (start[0] < 0 || start[0] >= m || start[1] < 0 || start[1] >= n)
            return false;

        if (visited[start[0]][start[1]]) return false;

        if (start[0] == dest[0] && start[1] == dest[1]) return true;

        visited[start[0]][start[1]] = true;

        for (int[] dir : point) {
            int x = start[0];
            int y = start[1];

            while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
                x += dir[0];
                y += dir[1];
            }

            x -= dir[0];
            y -= dir[1];

            if (dfs(maze, new int[]{x, y}, dest, visited)) {
                return true;
            }
        }

        return false;
    }
}
