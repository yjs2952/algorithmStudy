package codingtest.yanol.second;

import java.math.BigInteger;

public class P4 {

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

    private static int solution(String S) {

        BigInteger bigInteger = new BigInteger(S, 2);

        int result = 0;
        while (bigInteger.compareTo(BigInteger.valueOf(0)) > 0) {

            if (bigInteger.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))) {
                bigInteger = bigInteger.divide(BigInteger.valueOf(2));
            } else {
                bigInteger = bigInteger.subtract(BigInteger.valueOf(1));
            }
            result++;
        }
        return result;
    }
}
