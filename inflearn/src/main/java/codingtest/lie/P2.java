package codingtest.lie;

public class P2 {
    public static void main(String[] args) {
        String answerSheet1 = "4132315142";
        String[] sheet1 = {"3241523133", "4121314445", "3243523133", "4433325251", "2412313253"};

        String answerSheet2 = "53241";
        String[] sheet2 = {"53241", "42133", "53241", "14354"};

        String answerSheet3 = "24551";
        String[] sheet3 = {"24553", "24553", "24553", "24553"};

        P2 p2 = new P2();

        System.out.println(p2.solution(answerSheet1, sheet1));
        System.out.println(p2.solution(answerSheet2, sheet2));
        System.out.println(p2.solution(answerSheet3, sheet3));
    }

    String answerSheet;
    public int solution(String answer_sheet, String[] sheets) {
        this.answerSheet = answer_sheet;
        int answer = 0;
        for (int i = 0; i < sheets.length; i++) {
            for (int j = i; j < sheets.length; j++) {
                if (i == j) {
                    continue;
                }
                answer = Math.max(answer, calcCheatScore(sheets[i], sheets[j]));
            }
        }
        return answer;
    }
    private int calcCheatScore(String sheets1, String sheets2) {
        int totalSuspicious = 0;
        int longestConsecutiveSuspicious = 0;
        int currConsecutiveSuspicious = 1;
        boolean isConsecutive = false;
        for (int i = 0; i < sheets1.length(); i++) {
            if (isSuspiciousAnswer(sheets1, sheets2, i)) {
                totalSuspicious++;
                if (isConsecutive) {
                    currConsecutiveSuspicious++;
                    longestConsecutiveSuspicious = Math.max(longestConsecutiveSuspicious, currConsecutiveSuspicious);
                }
                isConsecutive = true;
                continue;
            }
//            currConsecutiveSuspicious = 1;
            isConsecutive = false;
        }
        return totalSuspicious + (int) Math.pow(longestConsecutiveSuspicious, 2);
    }
    private boolean isSuspiciousAnswer(String sheets1, String sheets2, int i) {
        return (sheets1.charAt(i) == sheets2.charAt(i)) && sheets1.charAt(i) != answerSheet.charAt(i);
    }
}
