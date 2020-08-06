package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P2 {

    private static final List<Integer> numbers = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toList());

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(isFake(input));
    }

    public static boolean isFake(String input) {
        String[] splits = input.split(" ");

        List<Integer> lottoNumbers = Arrays.stream(splits)
                .distinct()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (lottoNumbers.size() != 6) {
            return false;
        }

        for (Integer number : lottoNumbers) {
            if (!numbers.contains(number)) {
                return false;
            }
        }

        return isSorted(lottoNumbers);
    }

    private static boolean isSorted(List<Integer> lottoNumbers) {
        for (int i = 1; i < lottoNumbers.size(); i++) {
            if (lottoNumbers.get(i) < lottoNumbers.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
