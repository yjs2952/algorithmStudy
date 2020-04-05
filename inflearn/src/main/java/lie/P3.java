package lie;

public class P3 {
    public static void main(String[] args) {
        String road1 = "111011110011111011111100011111";
        int n1 = 3;

        String road2 = "001100";
        int n2 = 5;

        System.out.println(solution(road1, n1));
//        System.out.println(solution(road2, n2));
    }

    public static int solution(String road, int n) {
        int start = 0, end = 0, length = 0;

//        while (end < road.lastIndexOf("0")) {
            String newRoad = road.substring(start);

            int index = start;
            for (int i = 0; i < n; i++) {
                index = newRoad.indexOf("0", index);
                newRoad = newRoad.substring(index);
                System.out.println(index);
                System.out.println(newRoad);
            }
//        }

        return length;
    }
}
