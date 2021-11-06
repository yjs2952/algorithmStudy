package codingtest.navfi.n02;

public class P1 {
    public static void main(String[] args) {
        solution(123500900);
    }

    private static void solution(int N) {
        int enable_print = N % 10;

        while (N > 0) {
//            System.out.println("enable_print = " + enable_print);
//            System.out.println("N =" + N);
            if (enable_print == 0 && N % 10 != 0) {
                enable_print = 1;
                System.out.print(N % 10);
            } else if (enable_print == 1){
                System.out.print(N % 10); // 1
            }
//            System.out.println();
            N = N / 10;
        }
        System.out.println(); // 2
    }
}
