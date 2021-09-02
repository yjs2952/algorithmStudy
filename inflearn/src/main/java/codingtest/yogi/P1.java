package codingtest.yogi;

public class P1 {
    public static void main(String[] args) {
        System.out.println(solution(125));
        System.out.println(solution(10));
        System.out.println(solution(1));
        System.out.println(solution(1000000000));
    }

    private static int solution(int N) {
        String numberStr = String.valueOf(N);
        if (numberStr.length() > 1) {
            return (int) Math.pow(10, numberStr.length() - 1);
        }
        return 0;
    }
}
