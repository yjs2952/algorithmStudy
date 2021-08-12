package programmers.level2;

public class TargetNumber {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }

    private static int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }

    private static int dfs(int[] numbers, int node, int sum, int target) {
        if (node == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        return dfs(numbers, node + 1, sum + numbers[node], target) + dfs(numbers, node + 1, sum - numbers[node], target);
    }
}
