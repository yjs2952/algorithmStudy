package codingtest.woowa;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(getProgress(input));
    }

    private static int getProgress(String input) {
        int length = input.length();
        char first = input.charAt(0);

        int count = 0;
        for (int i = 1; i < length; i++) {
            if (first != input.charAt(i)) {
                count = i;
                break;
            }
        }

        double percentage = (double) count / length * 100;
        return (int) percentage;
    }
}
