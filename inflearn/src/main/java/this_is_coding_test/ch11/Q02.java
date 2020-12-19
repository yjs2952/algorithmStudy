package this_is_coding_test.ch11;

public class Q02 {
    public static void main(String[] args) {
        String input1 = "02984";
        String input2 = "567";
        String input3 = "5670";
        String input4 = "5067";

        System.out.println(solution(input1));
        System.out.println(solution(input2));
        System.out.println(solution(input3));
        System.out.println(solution(input4));
    }

    private static int solution(String input) {

        int first = Integer.parseInt(input.substring(0, 1));

        for (int i = 1; i < input.length(); i++) {

            int second = Integer.parseInt(input.substring(i, i + 1));

            if (first > 1 && second > 1) {
                first = first * second;
            } else {
                first = first + second;
            }
        }
        return first;
    }
}
