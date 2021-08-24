package inflearn.string;

import java.util.HashSet;
import java.util.Set;

public class _02JewelsAndStones {
    public static void main(String[] args) {
        System.out.println(solution("aA", "aAAbbbb"));
        System.out.println(solution("z", "ZZ"));
    }

    private static int solution(String jewels, String stones) {
        int result = 0;
        Set<Character> jewelSet = new HashSet<>();

        char[] jewelArray = jewels.toCharArray();
        for (char jewel : jewelArray) {
            jewelSet.add(jewel);
        }

        char[] stoneArray = stones.toCharArray();
        for (char stone : stoneArray) {
            if (jewelSet.contains(stone)) {
                result++;
            }
        }
        return result;
    }
}
