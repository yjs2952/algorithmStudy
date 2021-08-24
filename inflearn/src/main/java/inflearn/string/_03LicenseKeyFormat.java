package inflearn.string;

public class _03LicenseKeyFormat {
    public static void main(String[] args) {
        System.out.println(solution("8F3Z-2e-9-w", 4));
        System.out.println(solution(" 8-5g-3-J ", 2));
    }

    private static String solution(String s, int k) {
        String str = s.replace("-", "").trim();
        StringBuilder sb = new StringBuilder(str.toUpperCase());
        int length = sb.length();
        for (int i = k; i < length; i += k) {
            sb.insert(length - i, "-");
        }
        return sb.toString();
    }
}
