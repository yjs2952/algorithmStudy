package codingtest.kkmo;

import java.util.HashSet;
import java.util.Set;

public class P2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 0, 1, 1}, new int[]{2}));
        System.out.println(solution(new int[]{0, 0, 0, 0, 2, 3, 3}, new int[]{2, 5, 6}));
        System.out.println(solution(new int[]{0, 0, 1, 2}, new int[]{1, 2}));
        System.out.println(solution(new int[]{0, 3, 0, 0, 5, 0, 5}, new int[]{4, 2, 6, 1, 0}));
    }

    private static int solution(int[] T, int[] A) {
        Set<Integer> skillSet = new HashSet<>();
        int rootSkill = 0;
        skillSet.add(rootSkill);

        for (int skill : A) {
            skillSet.add(skill);
            int requiredSkill = T[skill];

            while (requiredSkill != rootSkill && !skillSet.contains(requiredSkill)) {
                skillSet.add(requiredSkill);
                requiredSkill = T[requiredSkill];
            }
        }
        return skillSet.size();
    }
}
