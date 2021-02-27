package codingtest.nav.n01;

public class Q2 {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, 9, 9};
        int target = 5;
        System.out.println(solution1(array, target));
    }

    private static int solution1(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m = (l + r) / 2;

            if (A[m] == X) {
                return m;
            }

            if (A[m] > X) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

//    private static int solution(int[] array, int target) {
//        int mid;
//        int left = 0;
//        int right = array.length - 1;
//
//        while (right >= left) {
//            mid = (right + left) / 2;
//
//            if (target == array[mid]) {
//                return mid;
//            }
//
//            if (target < array[mid]) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return -1;
//    }
}
