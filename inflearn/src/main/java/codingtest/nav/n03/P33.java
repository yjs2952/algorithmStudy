package codingtest.nav.n03;

public class P33 {
    public static void main(String[] args) {
        System.out.println(solution("BAAABAB"));
        System.out.println(solution("BBABAA"));
        System.out.println(solution("AABBB"));
    }

    private static int solution(String s) {
        int bCount = 0;
        int minDeleteCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                minDeleteCount = Math.min(bCount, minDeleteCount + 1);
            } else {
                bCount++;
            }
        }
        return minDeleteCount;
    }
}
