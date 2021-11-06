package codingtest.navfi.n06;

public class P2 {
    public static void main(String[] args) {
        System.out.println(solution2("baaaaa"));
        System.out.println(solution2("baaabbaabbba"));
        System.out.println(solution2("baabab"));
        System.out.println(solution2("aaa"));
        System.out.println(solution2("aa"));
    }

    private static int solution(String S) {
        int result = 0;
        int count = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(i - 1)) {
                count++;
            } else {
                result += count / 3;
                count = 1;
            }
        }
        result += count / 3;
        return result;
    }

    private static int solution2(String S) {
        int result = 0;
        int count = 1;

        char[] charArray = S.toCharArray();
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == charArray[i - 1]) {
                count += 1;
                if (count == 3) {
                    result += 1;
                }
            } else {
                count = 1;
            }
        }
        return result;
    }
}
