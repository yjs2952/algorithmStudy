package codingtest.zb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class P1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            list.add(br.readLine());
        }

        long number = Long.parseLong(list.get(0).split(" ")[1]);
        String message = list.get(1);

        System.out.println(solution1(message, number));
    }

    static String alphabets = "abcdefghizklmnopqrstuvwxyz";

    private static String solution1(String input, long number) {
        int length = input.length();
        int alphabetCnt = alphabets.length();

        StringBuilder sb = new StringBuilder();

        char[] charArray = input.toCharArray();
        for (int i = 1; i <= length; i++) {
            int msgIndex = alphabets.indexOf(charArray[i - 1]);
            BigInteger num = BigInteger.valueOf(number).pow(i);

            BigInteger remainder = num.add(BigInteger.valueOf(msgIndex)).remainder(BigInteger.valueOf(alphabetCnt));
            int encIndex = remainder.intValue();
            sb.append(alphabets.charAt(encIndex));
        }
        return sb.toString();
    }
}
