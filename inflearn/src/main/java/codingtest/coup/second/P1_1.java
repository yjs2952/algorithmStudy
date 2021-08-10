package codingtest.coup.second;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class P1_1 {
    public static void main(String[] args) {
        int n1 = 6;
        int[][] delivery1 = {{1, 3, 1}, {3, 5, 0}, {5, 4, 0}, {2, 5, 0}};

        int n2 = 7;
        int[][] delivery2 = {{5, 6, 0}, {1, 3, 1}, {1, 5, 0}, {7, 6, 0}, {3, 7, 1}, {2, 5, 0}};

        int n3 = 7;
        int[][] delivery3 = {{6, 5, 0}, {3, 1, 1}, {5, 1, 0}, {6, 7, 0}, {7, 3, 1}, {5, 2, 0}};

        System.out.println(solution(n1, delivery1));
        System.out.println(solution(n2, delivery2));
        System.out.println(solution(n3, delivery3));
    }

    private static String solution(int n, int[][] delivery) {

        Arrays.sort(delivery, Comparator.comparingInt(o -> -o[2]));

        Map<Integer, String> deliveryResult = new HashMap<>();
        for (int[] productNumbers : delivery) {
            putDeliveryResult(productNumbers, deliveryResult);
        }

        return getResult(n, deliveryResult);
    }

    private static void putDeliveryResult(int[] productNumbers, Map<Integer, String> deliveryResult) {
        boolean isDelivered = productNumbers[2] == 1;

        for (int i = 0; i < productNumbers.length - 1; i++) {
            int productNumber = productNumbers[i];

            if (isDelivered) {
                deliveryResult.put(productNumber, "O");
            } else {
                if ("O".equals(deliveryResult.get(productNumber))) {
                    int nextNumber = productNumber == productNumbers[0] ? productNumbers[1] : productNumbers[0];
                    deliveryResult.put(nextNumber, "X");
                }

                deliveryResult.putIfAbsent(productNumber, "?");
            }
        }
    }

    private static String getResult(int n, Map<Integer, String> deliveryResult) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(deliveryResult.getOrDefault(i, "?"));
        }
        return sb.toString();
    }
}
