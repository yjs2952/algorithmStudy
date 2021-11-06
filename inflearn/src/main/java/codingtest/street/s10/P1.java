package codingtest.street.s10;

public class P1 {
    public static void main(String[] args) {
        System.out.println(solution(28));
        System.out.println(solution(734));
        System.out.println(solution(1990));
        System.out.println(solution(1000));
        System.out.println(solution(10000));
        System.out.println(solution(50000));
        System.out.println(solution(1));
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
