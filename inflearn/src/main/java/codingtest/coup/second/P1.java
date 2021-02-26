package codingtest.coup.second;

import java.util.*;

public class P1 {
    public static void main(String[] args) {
        int n = 7;
        int[][] delivery = {{5,6,0},{1,3,1},{1,5,0},{7,6,0},{3,7,1},{2,5,0}};

        int n1 = 6;
        int[][] delivery1 = {{1,3,1},{3,5,0},{5,4,0},{2,5,0}};

        System.out.println(solution(n1, delivery1));
        System.out.println(solution(n, delivery));
    }

    private static String solution(int n, int[][] delivery) {
        Arrays.sort(delivery, Comparator.comparingInt(o -> -o[2]));
        List<Integer> deliveryList = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int[] input : delivery) {
            int firstProduct = input[0];
            int secondProduct = input[1];

            boolean isDelivered = input[2] == 1;

            if (isDelivered) {
                deliveryList.add(firstProduct);
                deliveryList.add(secondProduct);

                map.put(firstProduct, "O");
                map.put(secondProduct, "O");
                continue;
            }

            if (!deliveryList.isEmpty()) {
                if (deliveryList.contains(firstProduct)) {
                    map.put(secondProduct, "X");
                } else if (deliveryList.contains(secondProduct)) {
                    map.put(firstProduct, "X");
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (map.getOrDefault(i, null) == null) {
                sb.append("?");
            } else {
                sb.append(map.get(i));
            }
        }

        return sb.toString();
    }
}
