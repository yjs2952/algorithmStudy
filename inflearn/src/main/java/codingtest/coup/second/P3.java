package codingtest.coup.second;

import java.util.LinkedList;
import java.util.Queue;

public class P3 {
    private static final int[][] POSITION = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) {
        int[][] board1 = {{3,2,3,2}, {2,1,1,2}, {1,1,2,1}, {4,1,1,1}};
        int[][] board2 = {{4,2,3,2}, {2,1,2,4}, {1,2,3,1}, {4,1,4,3}};

        System.out.println(solution(board1));
        System.out.println(solution(board2));
    }

    private static int solution(int[][] board) {
        int result = 0;
        for (int i = 0; i < board.length; i++) {

            int count = 0;
            for (int j = 0; j < board[0].length; j++) {

            }
        }

        return result;
    }

//    private static void bfs(int[][] board, int i, int j) {
//        Queue<int[]> queue = new LinkedList<>();
//        queue.offer(new int[]{i, j});
//
//        while (!queue.isEmpty()) {
//            int number = board[i][j];
//            int size = queue.size();
//            int[] point = queue.poll();
//
//            for (int k = 0; k < size; k++) {
//                for (int[] pos : POSITION) {
//
//                    int x = point[0] + pos[0];
//                    int y = point[1] + pos[1];
//
//                    if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == number) {
//
//                        queue.offer(new int[]{x, y});
//                    }
//                }
//            }
//        }
//    }
}
