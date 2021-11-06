package codingtest.kkb;

public class P2 {
    public static void main(String[] args) {

    }

    static int max;
    static int[] result;

    public static int solution(int[][] needs, int r) {
        int answer = 0;
        result = new int[needs[0].length];
        combination(0, 0, needs[0].length, r, needs);
        answer = max;
        return answer;
    }

    private static void combination(int start, int cnt, int N, int r, int[][] needs) {
        if (cnt == r) {
            int sum = 0;
            outer:
            for (int[] need : needs) {
                for (int j = 0; j < N; j++) {
                    if (need[j] == 1 && result[j] != 1) {
                        continue outer;
                    }
                }
                sum++;
            }
            if (sum > max) {
                max = sum;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            result[i] = 1;
            combination(i + 1, cnt + 1, N, r, needs);
            result[i] = 0;
        }
    }
}
