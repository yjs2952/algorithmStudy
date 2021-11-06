package codingtest.cur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String[] split = input.split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);

        System.out.println(solution(a, b));
    }

    private static int solution(int a, int b) {

        Map<Integer, Integer> map = new HashMap<>();

        int maxValue = 0;
        for (int i = a; i <= b; i++) {
            int result = i;

            int count = 1;
            while (result != 1 && !map.containsKey(result)) {
                if (result % 2 == 0) {
                    result /= 2;
                } else {
                    result = (result * 3) + 1;
                }
                count++;
            }

            if (map.containsKey(result)) {
                count += map.get(result) - 1;
            }
            map.put(i, count);


            maxValue = Math.max(maxValue, count);
        }
        return maxValue;
    }
}
