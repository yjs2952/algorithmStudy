package codingtest.progr;

public class P2 {

    public static void main(String[] args) {
        int[][] office = {{5, -1, 4, 3}, {6, 3, -1, 2}, {2, -1, 1, 5}};
        int r = 1;
        int c = 0;
        String[] move = {"go", "go", "right", "go", "right", "go", "left", "go"};
        System.out.println(solution(office, r, c, move));
    }

    public static int solution(int[][] office, int r, int c, String[] move) {
        int answer = office[r][c];
        String dir = "go";

        int x = r;
        int y = c;

        for (String s : move) {

            if ("go".equals(s)) {
                if (dir.equals("go")) {
                    if (y == 0) continue;
                    y--;
                } else if (dir.equals("left")) {
                    if (x == 0) continue;
                    x--;
                } else {
                    if (x == office[0].length - 1) continue;
                    x++;
                }

                if (office[x][y] == -1) {
                    x = r;
                    y = c;
                } else {
                    c = y;
                    r = x;
                }

                answer += office[x][y];
            } else {
                dir = s;
            }
        }
        return answer;
    }
}
