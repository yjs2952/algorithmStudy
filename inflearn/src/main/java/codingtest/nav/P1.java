package codingtest.nav;

public class P1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{-3, -14, -5, 7, 8, 42, 8, 3}));
        System.out.println(solution(new int[]{2, -3, 3, 1, 10, 8, 2, 5, 13, -5, 3, -18}));
        System.out.println(solution(new int[]{-1000, 1000, 0, 0, 0, 1000, -1000, 0}));
    }

    private static String solution(int[] T) {
        int count = T.length / 4;
        int index = 0;
        int last = Integer.MIN_VALUE;
        String[] seasons = {"WINTER", "SPRING", "SUMMER", "AUTUMN"};

        for (int i = 0; i < T.length; i += count) {
            int diff = getAmplitude(T, i, count);

            if (diff > last) {
                index = i / count;
                last = diff;
            }
        }

        return seasons[index];
    }

    private static int getAmplitude(int[] T, int start, int count) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = start; i < start + count; i++) {
            max = Math.max(max, T[i]);
            min = Math.min(min, T[i]);
        }
        return max - min;
    }
}
