package codingtest.yanol.second;

import java.util.HashMap;
import java.util.Map;

public class P3 {
    public static void main(String[] args) {
        System.out.println(solution("15:15:00", "15:15:12"));
        System.out.println(solution("22:22:21", "22:22:23"));
    }

    private static int solution(String S, String T) {
        int result = 0;

        int[] arrayS = toIntegerArray(S.split(":"));
        int[] arrayT = toIntegerArray(T.split(":"));

        int minute = arrayS[1];
        int second = arrayS[2];

        for (int hh = arrayS[0]; hh <= arrayT[0]; hh++) {

            for (int mm = minute; mm < 60; mm++) {

                for (int ss = second; ss < 60; ss++) {

                    Map<Integer, Integer> map = new HashMap<>();
                    setInterestingDigits(map, hh);
                    setInterestingDigits(map, mm);
                    setInterestingDigits(map, ss);

                    if (map.size() <= 2) {
                        result++;
                    }

                    if (hh == arrayT[0] && mm == arrayT[1] && ss == arrayT[2]) {
                        return result;
                    }

                }
                second = 0;
            }
            minute = 0;
        }

        return result;
    }

    private static void setInterestingDigits(Map<Integer, Integer> map, int time) {

        if (time < 10) {
            map.put(0, map.getOrDefault(0, 0) + 1);
            map.put(time % 10, map.getOrDefault(time % 10, 0) + 1);
        } else {
            while (time != 0) {
                int num = time % 10;
                time /= 10;

                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
    }

    private static int[] toIntegerArray(String[] stringArray) {
        int[] array = new int[3];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(stringArray[i]);
        }
        return array;
    }
}
