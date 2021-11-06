package codingtest.kkmo;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class P1 {
    public static void main(String[] args) {
        String S = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
        String C = "Example";

        System.out.println(solution(S, C));
    }

    public static String solution(String S, String C) {
        StringJoiner joiner = new StringJoiner(", ");
        Map<String, Integer> map = new HashMap<>();

        String[] names = S.split(", ");
        for (String name : names) {
            String localName = createLocalName(name.split(" "));
            String domainName = C + ".com";

            String email = getEmail(localName, domainName, map);
            joiner.add(name + " <" + email + ">");
        }
        return joiner.toString();
    }

    private static String getEmail(String localName, String domainName, Map<String, Integer> map) {
        map.put(localName, map.getOrDefault(localName, 0) + 1);

        if (map.getOrDefault(localName, 0) > 1) {
            localName = localName + map.get(localName);
        }

        String email = localName + "@" + domainName;
        return email.toLowerCase();
    }

    private static String createLocalName(String[] splitName) {
        int length = splitName.length;
        String first = splitName[0].substring(0, 1);
        String middle = "";
        String last = splitName[length - 1].replace("-", "");

        if (length > 2) {
            middle = splitName[1].substring(0, 1);
        }

        if (last.length() > 8) {
            last = last.substring(0, 8);
        }

        return first + middle + last;
    }
}
