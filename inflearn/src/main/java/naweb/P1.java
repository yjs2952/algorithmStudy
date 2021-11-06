package naweb;

public class P1 {
    public static void main(String[] args) {
        System.out.println(solution("aabcbcd", "abc"));
        System.out.println(solution("aaaaabbbbb", "ab"));
    }

    private static int solution(String s, String t) {
        int result = 0;
        while (s.contains(t)) {
            s = s.replaceFirst(t, "");
            result++;
        }
        return result;
    }
}
