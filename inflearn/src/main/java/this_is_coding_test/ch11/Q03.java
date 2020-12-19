package this_is_coding_test.ch11;

public class Q03 {

    public static void main(String[] args) {
        String input = "0001100";

        System.out.println(solution(input));
    }

    private static int solution(String input) {

        int count0 = 0;
        int count1 = 0;

        if (input.charAt(0) == '1') {
            count0 += 1;
        } else {
            count1 += 1;
        }

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) != input.charAt(i + 1)) {
                if (input.charAt(i + 1) == '1') {
                    count0++;
                } else {
                    count1++;
                }
            }
        }

        return Math.min(count0, count1);
    }
}
