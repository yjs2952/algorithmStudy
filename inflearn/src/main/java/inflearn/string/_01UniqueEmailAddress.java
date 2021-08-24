package inflearn.string;

import java.util.HashSet;
import java.util.Set;

public class _01UniqueEmailAddress {
    public static void main(String[] args) {
        String[] emails1 = {"test.email+james@coding.com", "test.e.mail+toto.jane@coding.com", "testemail+tom@cod.ing.com"};
        String[] emails2 = {"a@coding.com", "b@coding.com", "c@coding.com"};
        System.out.println(solution(emails1));
        System.out.println(solution(emails2));
    }

    private static int solution(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            String localName = makeLocalName(email);
            String domainName = makeDomainName(email);

            uniqueEmails.add(localName + "@" + domainName);
        }

        return uniqueEmails.size();
    }

    private static String makeLocalName(String email) {
        String localName = email.substring(0, email.indexOf("@"));

        if (localName.contains("+")) {
            localName = localName.substring(0, localName.indexOf("+"));
        }

        if (localName.contains(".")) {
            localName = localName.replace(".", "");
        }
        return localName;
    }

    private static String makeDomainName(String email) {
        return email.substring(email.indexOf("@") + 1);
    }
}
