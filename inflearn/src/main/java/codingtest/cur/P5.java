package codingtest.cur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        List<Integer> containers = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            containers.add(Integer.parseInt(br.readLine()));
        }

        System.out.println(solution(containers));
    }

    private static int solution(List<Integer> containers) {
        containers.sort(Comparator.comparing(Math::abs));

        int count = 0;
        for (int i = 1; i < containers.size(); i++) {
            if ((containers.get(i) > 0 && containers.get(i - 1) < 0) || (containers.get(i) < 0 && containers.get(i - 1) > 0)) {
                count++;
            }
        }

        return count > 0 ? count + 1 : 0;
    }
}
