package codingtest.futurewiz;

public class P1 {
    public static void main(String[] args) {
        System.out.println(solution1("abab"));
        System.out.println(solution1("abcde"));
        System.out.println(solution1("a"));
        System.out.println(solution1("aab"));
    }

    private static int solution1(String plain) {
        int length = plain.length();
        for (int i = 0; i < length; i++) {
            if (isPalindrome(plain.substring(i))) {
                return i + length;
            }
        }
        return length * 2;
    }

    private static boolean isPalindrome(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }


    private static int solution(String plain) {
        int length = plain.length();
        if(plain.equals(new StringBuilder(plain).reverse().toString())) {
            return length;
        }

        for(int i = 1; i < length; i++) {
            StringBuilder sb = new StringBuilder(plain);
            sb.append(new StringBuilder(plain.substring(0, i)).reverse());

            if(sb.toString().equals(sb.reverse().toString())) {
                return sb.length();
            }
        }

        return 0;
    }
}
