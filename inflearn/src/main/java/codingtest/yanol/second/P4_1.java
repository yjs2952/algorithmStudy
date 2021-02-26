package codingtest.yanol.second;

import java.math.BigInteger;

public class P4_1 {
    private static BigInteger bigIntegerTwo = new BigInteger("2");

    public static void main(String[] args) {
        System.out.println(solution("011100"));
        System.out.println(solution("111"));
        System.out.println(solution("1111010101111"));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 400000; i++) {
            sb.append(1);
        }
        System.out.println(solution(sb.toString()));
    }

    public static int solution(String S) {
        BigInteger input = new BigInteger(S, 2);
        return getSteps(input, 0);
    }

    private static int getSteps(BigInteger input, int counter) {
        if (input.equals(BigInteger.ZERO)) return counter;
        counter++;
        if (input.mod(bigIntegerTwo).equals(BigInteger.ZERO)) {
            return getSteps(input.divide(bigIntegerTwo), counter);
        } else {
            return getSteps(input.subtract(BigInteger.ONE), counter);
        }
    }


}
