package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println("Hello Goorm! Your input is " + isValidate(input));
    }

    public static boolean isValidate(String input) {
        if (input == null || input.length() <= 0 || input.contains(" ")) {
            return false;
        }

        if (!input.matches("[1-2]*")) {
            return false;
        }

        if (input.charAt(input.length() - 1) == '1') {
            return false;
        }

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i - 1) == '1' && input.charAt(i) != '2') {
                return false;
            }
        }

        return true;
    }
}
