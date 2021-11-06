package codingtest.kkb;

public class P5 {
    public static void main(String[] args) {

    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length - 1; i++) {
            int cnt = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    cnt++;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}
