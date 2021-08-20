package codingtest.coup.third;

import java.util.*;

// 얘가 1번
public class P1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"alex pizza pasta", "alex pizza pizza", "alex noodle", "bob pasta", "bob noodle sandwich pasta", "bob steak noodle"})));
        System.out.println(Arrays.toString(solution(new String[]{"alex pizza pasta steak", "bob noodle sandwich pasta", "choi pizza sandwich pizza", "alex pizza pasta steak"})));
    }

    private static String[] solution(String[] orders) {
        Map<String, Set<String>> userOrderMap = new HashMap<>();
        Map<Integer, Set<String>> countMap = new HashMap<>();
        int max = 0;

        for (String order : orders) {
            String[] s = order.split(" ");
            String userName = s[0];
            Set<String> foods = new HashSet<>(Arrays.asList(s));

            setUserOrderMap(userOrderMap, userName, foods);

            if (userOrderMap.get(userName).size() >= max) {
                max = userOrderMap.get(userName).size();

                setCountMap(countMap, max, userName);
            }
        }
        return getResult(countMap.get(max));
    }

    private static String[] getResult(Set<String> names) {
        String[] result = new String[names.size()];

        int i = 0;
        for (String name : names) {
            result[i++] = name;
        }
        return result;
    }

    private static void setUserOrderMap(Map<String, Set<String>> userOrderMap, String name, Set<String> foods) {
        if (userOrderMap.containsKey(name)) {
            userOrderMap.get(name).addAll(foods);
            return;
        }
        userOrderMap.put(name, foods);
    }

    private static void setCountMap(Map<Integer, Set<String>> countMap, int max, String userName) {
        if (countMap.containsKey(max)) {
            countMap.get(max).add(userName);
            return;
        }
        countMap.put(max, new TreeSet<>(Collections.singletonList(userName)));
    }

}
