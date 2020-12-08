package codingtest.toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println("Hello Goorm! Your input is " + solution(input));
    }

    public static int solution(String input){
        String[] splitEnter = input.split("\\n");

        System.out.println(Arrays.toString(splitEnter));

        return splitEnter.length;
    }
}
