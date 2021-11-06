package codingtest.kkb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class P1 {
    public static void main(String[] args) {

    }

    public static int solution(String[] deposits) {
        String year = "2021";
        LocalDate dueDate = LocalDate.parse("2021-12-31", DateTimeFormatter.ISO_DATE);
        int sum = 0;
        for (String s : deposits) {
            String[] deposit = s.split(" ");
            String monthDay = deposit[0];

            LocalDate date = LocalDate.parse(year + "/" + monthDay, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            double interestRate = Integer.parseInt(deposit[1]) / 100.0;
            long money = Long.parseLong(deposit[2]);

            long remainDays = ChronoUnit.DAYS.between(date, dueDate);

            double decisionInterest = Math.floor(((double) money * interestRate) * ((double) remainDays / 365));

            sum += money + decisionInterest;
        }
        return sum;
    }
}
