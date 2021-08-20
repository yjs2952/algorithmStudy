package codingtest.mrt;

import java.util.*;

public class P1 {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        sc.nextLine();
        String[] logs = new String[n];
        for (int i = 0; i < n; i++) {
            logs[i] = sc.nextLine().trim();
        }
        solution(logs);
    }

    private static void solution(String[] logs) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add(logs[0]);

        int sameCount = 1;
        int samePosition = 0;
        for (int i = 1; i < logs.length; i++) {
            String nextLog = logs[i];
            String preLog = logs[i - 1];

            if (nextLog.equals(preLog)) {
                sameCount++;
                countMap.put(samePosition, sameCount);
            } else {
                samePosition++;
                sameCount = 1;
                list.add(nextLog);
            }
        }
        printResult(countMap, list);
    }

    private static void printResult(Map<Integer, Integer> countMap, List<String> list) {
        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++) {
            if (countMap.containsKey(i)) {
                System.out.println(list.get(i) + " (" + countMap.get(i) + ")");
                continue;
            }
            System.out.println(list.get(i));
        }
    }
}
