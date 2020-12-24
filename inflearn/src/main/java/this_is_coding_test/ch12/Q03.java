package this_is_coding_test.ch12;

public class Q03 {
    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));

        System.out.println((int) Math.log10(11234) + 1);
    }

    private static int solution(String input) {
        StringBuilder sb = new StringBuilder(input);

        int length = sb.length();

        for (int step = 1; step < sb.length() / 2 + 1; step++) {
            StringBuilder compressed = new StringBuilder();
            String prev = sb.substring(0, step);
            int count = 1;

            for (int j = step; j < sb.length(); j += step) {

                StringBuilder sub = new StringBuilder();
                for (int k = j; k < j + step; k++) {
                    if (k < sb.length()) sub.append(sb.charAt(k));
                }
                if (prev.contentEquals(sub)) {
                    count++;
                } else {
                    if (count > 1) {
                        compressed.append(count).append(prev);
                    } else {
                        compressed.append(prev);
                    }

                    prev = sub.toString();
                    count = 1;
                }
            }

            if (count > 1) {
                compressed.append(count).append(prev);
            } else {
                compressed.append(prev);
            }

            length = Math.min(length, compressed.length());
        }
        return length;
    }
}
