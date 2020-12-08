package codingtest.progr;

public class P1 {

    public static void main(String[] args) {
        String input_p = "82195";
        String input_s = "64723";

        System.out.println(solution(input_p, input_s));
    }

    public static int solution(String p, String s) {
        int answer = 0;

        char[] pArr = p.toCharArray();
        char[] sArr = s.toCharArray();
        boolean isTrue = true;

        for (char sValue : sArr) {
            int sNum = sValue - '0';

            for (char pValue : pArr) {
                int pNum = pValue - '0';

                int num = sNum - pNum;

                if (num < 0 && Math.abs(num) > 5) {
                    isTrue = true;
                } else isTrue = num >= 0 || Math.abs(num) >= 5;

                while (pNum != sNum) {
                    if (isTrue) {
                        pNum--;
                        if (pNum < 0) {
                            pNum = 9;
                        }
                    } else {
                        pNum++;
                        if (pNum > 9) {
                            pNum = 0;
                        }
                    }
                    answer++;
                }
            }
        }
        return answer;
    }
}
