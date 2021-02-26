package codingtest.yanol.second;

public class P4_2 {

    public static void main(String[] args) {
        System.out.println(solution("011100"));
        System.out.println(solution("111"));
        System.out.println(solution("1111010101111"));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 400000; i++) {
            sb.append(1);
        }
        System.out.println(solution(sb.toString()));
    }

    public static int solution(String S) {
        int firstOneAt = S.indexOf("1");
        return firstOneAt == -1 ? 0
                : S.replace("0", "").length() + S.length() - firstOneAt - 1;
    }
}
