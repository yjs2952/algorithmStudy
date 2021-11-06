package codingtest.woowa.t2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P5 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.lines()
                .map(String::toUpperCase)
                .filter(str -> str.length() >= 5 && str.length() < 10)
                .forEach(System.out::println);
    }
}
