package codingtest.cur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        List<Integer> eatTime = new ArrayList<>();
        for (String s : br.readLine().split(" ")) {
            eatTime.add(Integer.parseInt(s));
        }

        List<Integer> warmTime = new ArrayList<>();
        for (String s : br.readLine().split(" ")) {
            warmTime.add(Integer.parseInt(s));
        }

        System.out.println(solution(num, eatTime, warmTime));
    }

    private static int solution(int num, List<Integer> eatTime, List<Integer> warmTime) {
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            list.add(new int[]{eatTime.get(i), warmTime.get(i)});
        }

        int sum = 0;

        list.sort(Comparator.comparing(o -> -o[0]));

        for (int[] ints : list) {
            sum += ints[1];
        }

        sum += list.get(num - 1)[0];

        return sum;
    }


}
