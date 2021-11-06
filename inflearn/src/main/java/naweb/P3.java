package naweb;

/*
[13000, 88000, 10000]	[30, 20]	82000
[32000, 18000, 42500]	[50, 20, 65]	45275

 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P3 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{13000, 88000, 10000}, new int[]{30, 20}));
        System.out.println(solution(new int[]{32000, 18000, 42500}, new int[]{50, 20, 65}));
    }

    private static int solution(int[] prices, int[] discounts) {
        List<Integer> priceList = Arrays.stream(prices).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        List<Integer> discountList = Arrays.stream(discounts).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        double result = 0.0;

        for (int i = 0; i < priceList.size(); i++) {
            if (i < discountList.size()) {
                result += priceList.get(i) * (1 - discountList.get(i) / 100.0);
            } else {
                result +=  priceList.get(i);
            }
        }
        return (int) result;
    }
}
