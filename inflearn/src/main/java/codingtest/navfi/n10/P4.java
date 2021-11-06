package codingtest.navfi.n10;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P4 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"A B C D", "A D", "A B D", "B D"}, 2));
        System.out.println(solution(new String[]{"JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"}, 3));
    }

    private static int solution(String[] id_list, int k) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        StringTokenizer tokens;
        for (String s : id_list) {
            Map<String, Boolean> isVisited = new HashMap<>();
            tokens = new StringTokenizer(s);
            while (tokens.hasMoreTokens()) {
                String id = tokens.nextToken();
                if (map.get(id) == null) {
                    map.put(id, 1);
                    isVisited.put(id, true);
                    answer++;
                } else {
                    if (isVisited.get(id) == null && map.get(id) < k) {
                        map.replace(id, map.get(id) + 1);
                        isVisited.put(id, true);
                        answer++;
                    }
                }
            }
        }
        return answer;

    }
}
