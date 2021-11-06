package codingtest.zb;

public class P3 {
    public static void main(String[] args) {
//        System.out.println(solution(2, new int[]{1, 3, 5, 7, 9}));
        System.out.println(solution(2, new int[]{1, 3, 5, 7, 12}));
        System.out.println(solution(2, new int[]{1, 3, 5, 90, 100}));
    }

    private static int solution(int k, int[] stairs) {
        int length = stairs.length;

        int temp = length / k;

        int power = 10000000;
        for (int i = temp; i < length; i += temp) {
            power = Math.min(power, stairs[i] - stairs[i - temp]);
        }

        return power;
    }
}
