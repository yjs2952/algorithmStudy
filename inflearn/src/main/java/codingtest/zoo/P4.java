package codingtest.zoo;

import java.util.HashMap;
import java.util.Map;

public class P4 {
    public static void main(String[] args) {
        String S = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
        String C = "Example";

        System.out.println(solution(S, C));
    }

    public static String solution(String S, String C) {
        if (S == null || C == null || S.length() <= 0 || C.length() <= 0 || S.length() < 3)
            return null;

        StringBuilder result = new StringBuilder();
        Map<String, Integer> dupName = new HashMap<>();

        C = C.toLowerCase();

        String[] names = S.split("; ");

        for (String name : names) {
            String[] partsOfName = name.split(" ");

            String email = partsOfName[partsOfName.length - 1] + "_" + partsOfName[0];

            dupName.put(email, dupName.getOrDefault(email, 0) + 1);

            if (dupName.get(email) > 1) {
                email = partsOfName[partsOfName.length - 1] + "_" + partsOfName[0] + dupName.get(email);
            }

            email = email.replace("-", "").toLowerCase();

            result.append(name).append(" ").append("<").append(email).append("@").append(C).append(".com>; ");
        }

        return result.substring(0, result.lastIndexOf("; "));
    }
}
