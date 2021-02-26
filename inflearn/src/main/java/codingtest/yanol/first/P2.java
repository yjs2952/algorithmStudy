package codingtest.yanol.first;

public class P2 {

    public static void main(String[] args) {
        int[] array = {1, 0, 1, 0, 1, 1};
        int[] array1 = {1, 1, 0, 1, 1};
        int[] array2 = {0, 1, 0};
        int[] array3 = {0, 1, 1, 0};

        System.out.println(solution(array));
        System.out.println(solution(array1));
        System.out.println(solution(array2));
        System.out.println(solution(array3));
    }

    private static int solution(int[] array) {
        int first = 0;
        int second = 1;

        int result = 100;

        for (int i = 0; i < 2; i++) {
            int min = 0;
            for (int j = 0; j < array.length; j+=2) {
                if (array[j] != first) {
                    min++;
                }

                if (j != array.length - 1 && array[j + 1] != second) {
                    min++;
                }
            }

            result = Math.min(result, min);

            first = 1;
            second = 0;
        }

        return result;
    }
}
