package codingtest.woowa.t2;

import java.util.HashMap;
import java.util.Map;

public class P4 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"A", "B", "C"}, new String[]{"B", "C", "A"}));
        System.out.println(solution(new String[]{"A", "B", "C"}, new String[]{"D", "E", "C"}));
        System.out.println(solution(new String[]{"A", "B", "C", "D"}, new String[]{"B", "Z", "D", "C"}));
    }

    private static int solution(String[] before, String[] after) {
        int answer = 0;
        Map<String, Boolean> map = new HashMap<>();

        for (String s : before) {
            map.put(s, true);
        }

        int changeCount = 0;
        for (int i = 0; i < after.length; i++) {
            if (!before[i].equals(after[i])) {
                if (!map.containsKey(after[i])) {
                    answer++;
                } else {
                    changeCount++;
                }
            }
        }
        if (changeCount > 0) {
            answer += changeCount + 1;
        }

        return answer;
    }
}
