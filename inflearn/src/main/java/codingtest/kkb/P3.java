package codingtest.kkb;

public class P3 {
    public static void main(String[] args) {

    }

    static int max;

    public int solution(int n, int[] price) {
        int answer = -1;
        game(n, 0, 0, 0, price);
        answer = max;
        return answer;
    }

    private void game(int days, int day, int money, int stones, int[] price) {
        if (day >= days) {
            if (money > max) {
                max = money;
            }
            return;
        }

        if (price[day] == 0) {
            game(days, day + 1, money, stones + 1, price);
        } else {

            if (money < price[day]) {
                game(days, day + 1, money, stones, price);
            } else {
                game(days, day + 1, money, stones, price);
                game(days, day + 1, money - price[day], stones + 1, price);
            }

            if (stones > 0) {
                game(days, day + 1, money + (price[day] * stones), 0, price);
            }
        }
    }
}
