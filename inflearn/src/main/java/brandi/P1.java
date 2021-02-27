package brandi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> heartRates = new ArrayList<>();

        String temp;
        while ((temp = br.readLine()) != null) {
            heartRates.add(temp);
        }

        System.out.println(answer(heartRates));
    }

    private static String answer(List<String> heartRates) {
        int[] result = new int[6];
        StringBuilder sb = new StringBuilder();

        int age = Integer.parseInt(heartRates.get(0));
        int maxHeartRate = 220 - age;

        for (int i = 1; i < heartRates.size(); i++) {
            int heartRate = Integer.parseInt(heartRates.get(i));
            double percent = (double) heartRate / maxHeartRate * 100;

            if (percent < 60) {
                result[0]++;
            } else if (percent >= 60 && percent < 68) {
                result[1]++;
            } else if (percent >= 68 && percent < 75) {
                result[2]++;
            } else if (percent >= 75 && percent < 80) {
                result[3]++;
            } else if (percent >= 80 && percent < 90) {
                result[4]++;
            } else if (percent >= 90) {
                result[5]++;
            }
        }

        for (int i = result.length - 1; i >= 0; i--) {
            sb.append(result[i]).append(" ");

            if (i == 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
