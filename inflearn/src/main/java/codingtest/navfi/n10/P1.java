package codingtest.navfi.n10;

import java.util.*;

public class P1 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"A B C D", "A D", "A B D", "B D"}, 2));
        System.out.println(solution(new String[]{"JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"}, 3));
    }

    private static int solution(String[] id_list, int k) {
        Map<String, Integer> couponMap = new HashMap<>();
        int result = 0;

        for (String ids : id_list) {
            StringTokenizer st = new StringTokenizer(ids, " ");
            Set<String> idSet = new HashSet<>();

            while (st.hasMoreTokens()) {
                idSet.add(st.nextToken());
            }

            for (String id : idSet) {
                Integer count = couponMap.getOrDefault(id, 0);

                if (count < k) {
                    couponMap.put(id, count + 1);
                    result++;
                }
            }
        }

        return result;
    }
}
