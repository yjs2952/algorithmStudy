import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {

    /**
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
     * Input: [[0,30],[5,10],[15,20]]
     * Output: false
     * Input: [[7,10],[2,4]]
     * Output: true
     */
    public static void main(String[] args) {
        int[][] input1 = {{0, 30}, {5, 10}, {15, 20}};
        int[][] input2 = {{2, 4}, {2, 10}};

        System.out.println("output1 : " + canAttendAllMeeting(input1));
        System.out.println("output2 : " + canAttendAllMeeting(input2));
    }

    private static boolean canAttendAllMeeting(int[][] input){

        if (input == null) return false;

        Arrays.sort(input, Comparator.comparingInt(o -> o[0]));

        System.out.println(Arrays.deepToString(input));

        for (int i = 1; i < input.length; i++) {

            if (input[i - 1][1] > input[i][0]) {
                return false;
            }
        }

        return true;
    }
}
