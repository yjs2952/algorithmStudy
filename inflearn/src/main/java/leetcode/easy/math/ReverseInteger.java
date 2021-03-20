package leetcode.easy.math;

public class ReverseInteger {
    public static void main(String[] args) {
        int input1 = 123;
        int input2 = -123;
        int input3 = 120;
        int input4 = 0;

        System.out.println(solution(input1));
        System.out.println(solution(input2));
        System.out.println(solution(input3));
        System.out.println(solution(input4));
    }

    private static int solution(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }

        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int)res;
        }
    }
}
