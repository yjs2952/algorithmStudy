package this_is_coding_test.ch03;

public class _01_change {
    public static void main(String[] args) {
        int input = 1260;
        System.out.println("result : " + solution(input));
    }

    private static int solution(int change) {
        int[] coinTypes = {500, 100, 50, 10};

        int count = 0;

        for (int coinType : coinTypes) {
            count += (change / coinType);
            change = change % coinType;
        }

        return count;
    }
}
