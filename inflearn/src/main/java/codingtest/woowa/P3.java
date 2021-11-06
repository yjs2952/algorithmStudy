package codingtest.woowa;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputNumber = br.readLine();
        int number = getNumber(inputNumber);

        String[] strArray = new String[number];
        for (int i = 0; i < number; i++) {
            strArray[i] = br.readLine();
        }

        solution(strArray);
    }

    private static int getNumber(String input) {
        int number = 0;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
        return number;
    }

    private static void solution(String[] strArray) {
        for (String input : strArray) {
            String[] splits = input.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String split : splits) {
                StringBuilder sbSplit = new StringBuilder(split);
                sb.append(sbSplit.reverse()).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
