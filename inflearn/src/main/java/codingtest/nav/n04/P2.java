package codingtest.nav.n04;

public class P2 {
    public static void main(String[] args) {
        solution(10);
        System.out.println();
        solution(1);
    }

    private static void solution(int N){
        int enable_print = N % 10;
        while (N > 0) {
            if (enable_print == 0 && N % 10 != 0) {
                enable_print = 1;
                System.out.print(N % 10);   // 1
            }
            else if (enable_print == 1) {
                System.out.print(N % 10);
            }
            N = N / 10;
        }
    }
}
