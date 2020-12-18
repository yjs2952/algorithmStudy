package codingtest.yanol;

/**
 * n < ?? < 1000000000
 */
public class P1 {

    private final static int MAX_BOUND = 1000000000;

    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(60));
        System.out.println(solution(999999999));
    }

    public static int solution(int n) {
        int randDomNumber = (int) (Math.random() * (MAX_BOUND - n) + n + 1);

        if (randDomNumber % 10 == 0) {
            return randDomNumber;
        } else {
            return (randDomNumber / 10 * 10) + (int) (Math.random() * (MAX_BOUND - randDomNumber) / 10 + 1) * 10;
        }
    }
}
