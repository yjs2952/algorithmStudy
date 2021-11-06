package codingtest.navfi.n08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P1 {
    public static void main(String[] args) {
        System.out.println(solution(4));
        System.out.println(solution(7));
        System.out.println(solution(200));
    }

    private static int solution(int N) {
        int n = 20000000;
        List<Integer> list = new ArrayList<>();
        int p2 = 1;

        while (list.size() < 200) {
            int p2n3 = p2;

            while (p2n3 < n) {
                if (list.size() > 200) {
                    break;
                }
                list.add(p2n3);
                p2n3 *= 3;
            }

            p2 *= 2;
        }
        Collections.sort(list);
        return list.get(N);
    }
}
