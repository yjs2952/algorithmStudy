package zoo;

public class P3 {
    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4};
        int[] input2 = {3, 4, 5, 3, 7};
        int[] input3 = {1, 3, 1, 2};
        int[] input4 = {1, 3, 1, 2, 4, 1, 9};
        int[] input5 = {1, 3, 3, 2, 4, 1, 9};

        System.out.println(solution(input1));
        System.out.println(solution(input2));
        System.out.println(solution(input3));
        System.out.println(solution(input4));
        System.out.println(solution(input5));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8

        if (A == null || A.length < 4)
            return -1;

        for (int i = 1; i < A.length; i++) {
            if (A[i]==A[i-1]) return -1;
        }

        if (isAesthetic(A)) {
            return 0;
        }

        int result = 0;
        int[] arr = new int[A.length - 1];

        for (int i = 0; i < A.length; i++) {
            int index = 0;
            for (int j = 0; j < A.length; j++) {
                if (i != j) {
                    arr[index] = A[j];
                    index++;
                }
            }

            if (isAesthetic(arr)) result++;
        }

        if (result == 0) {
            return -1;
        }

        return result;
    }

    private static boolean isAesthetic(int[] arr) {
        boolean[] bool = new boolean[arr.length - 1];

        for (int i = 1; i < arr.length; i++) {
            bool[i - 1] = arr[i] > arr[i - 1];
        }

        for (int i = 1; i < bool.length; i++) {
            if (bool[i - 1] == bool[i]) return false;
        }

        return true;
    }
}
