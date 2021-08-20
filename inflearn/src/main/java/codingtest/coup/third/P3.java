package codingtest.coup.third;

import java.util.*;

// 얘가 3번
public class P3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(1, new String[]{"1 fracta", "1 sina", "1 hana", "1 robel", "1 abc", "1 sina", "1 lynn"})));
        System.out.println(Arrays.toString(solution(4, new String[]{"1 a", "1 b", "1 abc", "3 b", "3 a", "1 abcd", "1 abc", "1 aaa", "1 a", "1 z", "1 q", "3 k", "3 q", "3 z", "3 m", "3 b"})));

    }

    private static String[] solution(int n, String[] record) {
        Map<String, Boolean>[] map = new Map[n + 1];
        Queue<String>[] queue = new Queue[n + 1];
        int maxCount = 5;

        for (int i = 1; i < n + 1; i++) {
            map[i] = new HashMap<>();
            queue[i] = new LinkedList<>();
        }

        for (String str : record) {
            String[] splits = str.split(" ");
            int server = Integer.parseInt(splits[0]);
            String nickName = splits[1];

            if (!map[server].containsKey(nickName)) {
                queue[server].offer(nickName);
                map[server].put(nickName, true);

                if (queue[server].size() > maxCount) {
                    map[server].remove(queue[server].poll());
                }
            }
        }

        return getResult(n, queue);
    }

    private static String[] getResult(int n, Queue<String>[] queue) {
        int sum = 0;
        for (int i = 1; i < n + 1; i++) {
            sum += queue[i].size();
        }

        String[] answer = new String[sum];
        int cnt = 0;
        for (int i = 1; i < n + 1; i++) {
            while (!queue[i].isEmpty()) {
                answer[cnt++] = queue[i].poll();
            }
        }
        return answer;
    }
}