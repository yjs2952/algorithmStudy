package codingtest.navfi.n08;

public class P3 {
    public static void main(String[] args) {
        System.out.println(solution("ac"));
        System.out.println(solution("acb"));
        System.out.println(solution("hot"));
        System.out.println(solution("codility"));
    }

    private static String solution(String S) {
        int length = S.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length - 1; i++) {

            char[] charArray = S.toCharArray();
            if (charArray[i] > charArray[i + 1]) {

                for (int j = 0; j < length; j++) {
                    if (i != j) {
                        result.append(charArray[j]);
                    }
                }
                return result.toString();
            }
        }

        return S;
    }
}
