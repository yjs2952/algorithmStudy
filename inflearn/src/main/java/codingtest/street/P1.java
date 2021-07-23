package codingtest.street;

public class P1 {
    public static void main(String[] args) {
        int num1 = 28;
        int num2 = 734;
        int num3 = 1990;
        int num4 = 1000;
        int num5 = 10001;

        System.out.println(solution(num1));
        System.out.println(solution(num2));
        System.out.println(solution(num3));
        System.out.println(solution(num4));
        System.out.println(solution(num5));
    }

    private static int solution(int N) {

        int sum = getSum(N);

        if (sum == 1) {
            return N * 10;
        }

        while (true) {

            N = N + 1;
            int result = getSum(N);

            if (sum == result) {
                break;
            }
        }
        return N;
    }

    private static int getSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
