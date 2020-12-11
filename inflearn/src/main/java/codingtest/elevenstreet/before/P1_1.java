package codingtest.elevenstreet.before;

public class P1_1 {

    public static void main(String[] args) {
        String input = "aabab";
        String input1 = "dog";
        String input2 = "aa";
        String input3 = "a";

        System.out.println(solution(input));
        System.out.println(solution(input1));
        System.out.println(solution(input2));
        System.out.println(solution(input3));
    }

    private static int solution(String input) {
        if (input.contains("aaa")) {
            return -1;
        }
        StringBuilder filterS = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            String letter = input.substring(i, i + 1); // substring => new String(value,start,end)

            if (!"a".equals(letter)) {
                filterS.append(letter);
            }
        }

        int beforeCount = input.length() - filterS.length();
        int afterCount = (filterS.length() + 1) * 2;
        return afterCount - beforeCount;
    }
}
