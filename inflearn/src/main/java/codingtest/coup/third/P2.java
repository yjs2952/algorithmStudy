package codingtest.coup.third;

public class P2 {
    // 얘가 2번
    public static void main(String[] args) {
        System.out.println(solution1(new int[]{1, 2, 3}));
        System.out.println(solution1(new int[]{3, -1, 0, 4}));
        System.out.println(solution1(new int[]{3, -1, 0, 4, 3, 2, 1, 3, 4, 2, 1, 3}));
        System.out.println(solution1(new int[]{0, 0, 0, 0}));
    }

    private static int solution1(int[] s) {
        int count = 0;
        boolean toggle = false;

        int current = s[0];
        for (int i = 1; i < s.length; i++) {
            int next = s[i];

            boolean condition = toggle ? current > next : current < next;
            int value = toggle ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            if (condition) {
                current = next;
            } else {
                count++;
                current = value;
                i--;
            }
            toggle = !toggle;
        }

        return count;
    }
}
