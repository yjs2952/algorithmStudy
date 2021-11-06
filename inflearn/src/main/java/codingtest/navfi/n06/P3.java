package codingtest.navfi.n06;

public class P3 {
    public static void main(String[] args) {
        System.out.println(solution("BAAABAB"));
        System.out.println(solution("BBABAA"));
        System.out.println(solution("AABBBB"));
    }

    private static int solution(String S) {
        char charA = 'A';
        int bCount = 0;
        int deleteCount = 0;

        for (char c : S.toCharArray()) {
            if (charA == c) {
                // minimum deletions with this character included
                // is equal to count of all Bs before it
                deleteCount = Math.min(bCount, deleteCount + 1);
            } else {
                bCount++;
                // there is no need to exclude the last B at the end of
                // the string, the deleteCount does not change
            }
        }
        return deleteCount;
    }
}
