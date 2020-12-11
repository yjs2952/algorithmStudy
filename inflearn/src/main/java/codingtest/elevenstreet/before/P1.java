package codingtest.elevenstreet.before;

public class P1 {

    public static void main(String[] args) {
        String input = "aabab";
        String input1 = "dog";
        String input2 = "aa";
        String input3 = "baaaa";

        System.out.println(solution(input));
        System.out.println(solution(input1));
        System.out.println(solution(input2));
        System.out.println(solution(input3));
    }

    private static int solution(String input) {
        // "aaa" 포함 시 -1 리턴
        if (input.contains("aaa")) {
            return -1;
        }

        int result = 0;
        int aDuplicateCount = 0;
        for (int i = 0; i < input.length(); i++) {

            if (input.substring(i, i + 1).equals("a")) {
                aDuplicateCount++;
            } else {
                if (aDuplicateCount == 1) {
                    result++;
                }

                if (aDuplicateCount == 0) {
                    result += 2;
                }

                aDuplicateCount = 0;
            }

            if (i == input.length() - 1) {
                if (input.substring(i, i + 1).equals("a")) {
                    if (aDuplicateCount == 1) {
                        result++;
                    }
                } else {
                    result += 2;
                }
            }
        }

        return result;
    }
}
