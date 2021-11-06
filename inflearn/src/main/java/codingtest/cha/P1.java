package codingtest.cha;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class P1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int afterRows = Integer.parseInt(bufferedReader.readLine().trim());
        int afterColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> after = new ArrayList<>();

        IntStream.range(0, afterRows).forEach(i -> {
            try {
                after.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<List<Integer>> result = Result.findBeforeMatrix(after);

        result.stream()
                .map(
                        r -> r.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                )
                .map(r -> r + "\n")
                .collect(toList())
                .forEach(System.out::println);

        bufferedReader.close();
    }
}

class Result {

    /*
     * Complete the 'findBeforeMatrix' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY after as parameter.
     */

    public static List<List<Integer>> findBeforeMatrix(List<List<Integer>> after) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();

        int number;
        for (int i = 0; i < after.size(); i++) {
            for (int j = 0; j < after.get(0).size(); j++) {
                if (i == 0 && j == 0) {

                }
            }
        }
        return null;
    }

}
