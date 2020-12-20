package this_is_coding_test.ch11;

public class Q5 {
    public static void main(String[] args) {
        int[] array = {1, 3, 2, 3, 2};
        int[] array2 = {1, 5, 4, 3, 2, 4, 5, 2};
        System.out.println(solution(array, 5, 3));
        System.out.println(solution(array2, 8, 5));
    }

    private static int solution(int[] weights, int n, int m) {
        int count = 0;

        int[] array = new int[m + 1];
        for (int weight : weights) {
            array[weight]++;
        }

        for (int i = 1; i <= m; i++) {
            n -= array[i];
            count += array[i] * n;
        }
        return count;
    }
}