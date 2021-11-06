package codingtest.kkb;

import java.util.ArrayList;
import java.util.List;

public class P4 {
    public static void main(String[] args) {

    }

    static List<Integer>[] graph;
    static boolean[] isExecuted;
    static int min = 0;

    public int solution(int[] T, int[][] R, int k) {
        int answer = 0;
        int N = T.length;
        graph = new ArrayList[N + 1];
        isExecuted = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] ints : R) {
            graph[ints[1]].add(ints[0]);
        }
        dfs(k, T, T[k - 1]);
        answer = min;
        return answer;
    }

    private static void dfs(int cur, int[] T, int sum) {
        if (sum > min) {
            min = sum;
        }
        List<Integer> children = graph[cur];
        for (int child : children) {
            if (!isExecuted[child]) {
                isExecuted[child] = true;
                dfs(child, T, sum + T[child - 1]);
                isExecuted[child] = false;
            } else {
                return;
            }
        }
    }
}
