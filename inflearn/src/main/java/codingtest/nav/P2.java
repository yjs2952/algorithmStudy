package codingtest.nav;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class P2 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(solution("Sun 10:00-20:00\n" +
                "Fri 05:00-10:00\n" +
                "Fri 16:30-23:50\n" +
                "Sat 10:00-24:00\n" +
                "Sun 01:00-04:00\n" +
                "Sat 02:00-06:00\n" +
                "Tue 03:30-18:15\n" +
                "Tue 19:00-20:00\n" +
                "Wed 04:25-15:14\n" +
                "Wed 15:14-22:40\n" +
                "Thu 00:00-23:59\n" +
                "Mon 05:00-13:00\n" +
                "Mon 15:00-21:00"));
        long end = System.currentTimeMillis();

        System.out.println("perform1" + (end - start));

        start = System.currentTimeMillis();
        System.out.println(solution2("Sun 10:00-20:00\n" +
                "Fri 05:00-10:00\n" +
                "Fri 16:30-23:50\n" +
                "Sat 10:00-24:00\n" +
                "Sun 01:00-04:00\n" +
                "Sat 02:00-06:00\n" +
                "Tue 03:30-18:15\n" +
                "Tue 19:00-20:00\n" +
                "Wed 04:25-15:14\n" +
                "Wed 15:14-22:40\n" +
                "Thu 00:00-23:59\n" +
                "Mon 05:00-13:00\n" +
                "Mon 15:00-21:00"));
        end = System.currentTimeMillis();

        System.out.println("perform2" + (end - start));

//        System.out.println(solution("Mon 01:00-23:00\n" +
//                "Tue 01:00-23:00\n" +
//                "Wed 01:00-23:00\n" +
//                "Thu 01:00-23:00\n" +
//                "Fri 01:00-23:00\n" +
//                "Sat 01:00-23:00\n" +
//                "Sun 01:00-21:00"));
    }

    private static int solution(String S) {
        List<String> weekdays = Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");

        List<int[]> list = Arrays.stream(S.split("\n"))
                .map(str -> {
                    int weekday = weekdays.indexOf(str.substring(0, 3));
                    String[] time = str.substring(4).split("-");

                    int startHour = Integer.parseInt(time[0].substring(0, 2));
                    int startMinute = Integer.parseInt(time[0].substring(3));

                    int endHour = Integer.parseInt(time[1].substring(0, 2));
                    int endMinute = Integer.parseInt(time[1].substring(3));

                    int start = startHour * 60 + (weekday * 24 * 60) + startMinute;
                    int end = endHour * 60 + (weekday * 24 * 60) + endMinute;
                    return new int[]{weekday, start, end};
                }).sorted((o1, o2) -> {
                    if (o1[2] == o2[2]) {
                        if (o1[1] == o2[1]) {
                            return o1[0] - o2[0];
                        }
                        return 0;
                    }
                    if (o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    }
                    return o1[2] - o2[2];
                }).collect(Collectors.toList());

        list.add(new int[]{6, 10080, 10080});

        int max = 0;
        for (int i = 1; i < list.size(); i++) {
            int term = list.get(i)[1] - list.get(i - 1)[2];
            max = Math.max(max, term);
        }
        return max;
    }

    public static int solution2(String S) {
        List<String> weekdays = Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");
        int size = 10080;
        boolean[] schedule = new boolean[size];
        StringTokenizer lines = new StringTokenizer(S, "\r\n");

        while (lines.hasMoreTokens()) {
            String line = lines.nextToken();
            int weekday = weekdays.indexOf(line.substring(0, 3));

            int startHour = Integer.parseInt(line.substring(4, 6));
            int startMinute = Integer.parseInt(line.substring(7, 9));
            int endHour = Integer.parseInt(line.substring(10, 12));
            int endMonth = Integer.parseInt(line.substring(13, 15));

            int start = (weekday * 24 * 60) + (startHour * 60) + startMinute;
            int end = (weekday * 24 * 60) + (endHour * 60) + endMonth;

            for (int i = start; i < end; i++) {
                schedule[i] = true;
            }

            if (weekday == 6 && endHour == 24) {
                schedule[size - 1] = true;
            }
        }

        int max = 0;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (!schedule[i]) {
                sum++;
                max = Math.max(max, sum);
            } else {
                sum = 0;
            }
        }
        return max;
    }
}
