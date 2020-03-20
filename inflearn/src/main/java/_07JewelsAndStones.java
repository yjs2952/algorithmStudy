import java.util.HashSet;
import java.util.Set;

public class _07JewelsAndStones {

    /**
     * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
     * Each character in S is a type of stone you have.
     * You want to know how many of the stones you have are also jewels.
     * The letters in J are guaranteed distinct, and all characters in J and S are letters.
     * Letters are case sensitive, so "a" is considered a different type of stone from "A".
     *
     * Input: J = "aA", S = "aAAbbbb
     * Output: 3
     */
    public static void main(String[] args) {
        String inputJ = "aA";
        String inputS = "aAAbbbb";

        System.out.println("result : " + solve(inputJ, inputS));
    }

    public static int solve(String inputJ, String inputS) {

        int result = 0;

        /*for (int i = 0; i < inputJ.length(); i++) {
            for (int j = 0; j < inputS.length(); j++) {
                if (inputJ.charAt(i) == inputS.charAt(j)) {
                    result++;
                }
            }
        }*/

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < inputJ.length(); i++) {
            set.add(inputJ.charAt(i));
        }

        for (char c : inputS.toCharArray()) {
            if (set.contains(c)) {
                result++;
            }
        }
        return result;
    }
}
