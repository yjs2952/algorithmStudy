package codingtest.yogi;

public class PP {
    public static void main(String[] args) {
        System.out.println(solution("1011"));
        System.out.println(solution("0110011"));
        System.out.println(solution("000111"));
    }

    private static int solution(String s) {
        char[] chars = s.toCharArray();
        int zeroCnt = 0;
        for (char ch : chars) {
            if (ch == '0') {
                zeroCnt++;
            }
        }
        return Math.abs(zeroCnt - (s.length() - zeroCnt));
    }
}
