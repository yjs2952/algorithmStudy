package inflearn.sort_searching;

import java.util.Arrays;

public class _07LogDataSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"dig1 8 2 3 1", "let1 abc cat", "dig1 2 5", "let2 good dog book", "let3 abc zoo"})));
    }

    private static String[] solution(String[] logs) {
        Arrays.sort(logs, (o1, o2) -> {
            String[] splits1 = o1.split(" ", 2);
            String[] splits2 = o2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(splits1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(splits2[1].charAt(0));

            if (!isDigit1 && !isDigit2) {   // 모두 문자
                int comp = splits1[1].compareTo(splits2[1]);
                if (comp == 0) {
                    return splits1[0].compareTo(splits2[0]);
                } else {
                    return comp;
                }
            } else if (isDigit1 && isDigit2) {  // 모두 숫자
                return 0;
            } else if (isDigit1 && !isDigit2) { // 첫번째 숫자, 두번째 문자
                return 1;
            } else {                            // 첫번째 문자, 두번째 숫자
                return -1;
            }
        });
        return logs;
    }
}
