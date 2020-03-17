public class LicenseKeyFormatting {
    /**
     * You are given a license key represented as a string S which consists only alphanumeric character and dashes.
     * The string is separated into N+1 groups by N dashes.
     * Given a number K, we would want to reformat the strings such that each group contains exactly K characters, except for the first group which could be shorter than K, but still must contain at least one character.
     * Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.
     * Given a non-empty string S and a number K, format the string according to the rules described above.
     *
     * input
     * String str = "8F3Z-2e-9-w";
     * String str = "8-5g-3-J";
     * int k =4;
     * Output : 8F3Z-2E9W 8F3Z-2E9W, 8-5G3J
     */
    public static void main(String[] args) {
        String input1 = "8F3Z-2e-9-w-qpr";
        String input2 = "8-5g-3-J";

        int k = 4;

        System.out.println("result1 : " + solve(input1, k));
        System.out.println("result2 : " + solve(input2, k));
    }

    private static String solve(String input, int k){

        String newStr = input.replaceAll("-", "");
        newStr  = newStr.toUpperCase();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < newStr.length(); i++) {
            sb.append(newStr.charAt(i));
        }

        int length = sb.length();
        for (int i = k; i < length; i += k) {
            sb.insert(length - i, '-');
        }

        return sb.toString();
    }
}
