package codingtest.yanol;

public class P4 {

    public static void main(String[] args) {
        int[] array = {2, 4, 1, 6, 5, 9, 7};
        int[] array1 = {4, 3, 2, 6, 1};
        int[] array2 = {2, 1, 6, 4, 3, 7};
        System.out.println(solution(array));
        System.out.println(solution(array1));
        System.out.println(solution(array2));
    }

    private static int solution(int[] array) {
        int ans = 0, max_so_far = 0;
        for (int i = 0; i < array.length; i++) {

            // Find maximum in prefix arr[0..i]
            max_so_far = Math.max(max_so_far, array[i]);

            // If maximum so far is equal to index,
            // we can make a new partition ending at
            // index i.
            if (max_so_far == i)
                ans++;
        }
        return ans;
    }
}
