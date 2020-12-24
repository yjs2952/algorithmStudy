package codingtest.yanol;

public class P3 {

    public static void main(String[] args) {
        int number = 268;
        int number1 = 670;
        int number2 = 0;
        int number3 = -999;
        int number4 = -8000;
        int number5 = 8000;
        int number6 = 5321;
        int number7 = -4440;
        int number8 = 6666;

        System.out.println(solution(number));
        System.out.println(solution(number1));
        System.out.println(solution(number2));
        System.out.println(solution(number3));
        System.out.println(solution(number4));
        System.out.println(solution(number5));
        System.out.println(solution(number6));
        System.out.println(solution(number7));
        System.out.println(solution(number8));
    }

    private final static int FIVE = 5;

    private static int solution(int number) {
        String stringNumber = String.valueOf(Math.abs(number));
        StringBuilder sb = new StringBuilder(stringNumber);

        boolean isSuccess = false;
        for (int i = 0; i < stringNumber.length(); i++) {
            int unit = Integer.parseInt(stringNumber.substring(i, i + 1));

            if (number >= 0) {
                if (unit <= FIVE) {
                    sb.insert(i, FIVE);
                    isSuccess = true;
                    break;
                }
            } else {
                if (unit > FIVE) {
                    sb.insert(i, FIVE);
                    sb.insert(0, "-");
                    isSuccess = true;
                    break;
                }
            }
        }

        if (number >=0 && !isSuccess) {
            sb.append(FIVE);
        } else if (number < 0 && !isSuccess) {
            sb.append(FIVE);
            sb.insert(0, "-");
        }

        return Integer.parseInt(sb.toString());
    }
}
