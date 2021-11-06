package codingtest.cur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] split = input.split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        System.out.println(solution(n, m));
    }

    private static int solution(int n, int m) {

        int couponCnt = n  + (n / m);
        int extraPizzaCnt = couponCnt / m;

        return n + extraPizzaCnt;
    }


}
