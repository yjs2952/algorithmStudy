package this_is_coding_test.ch11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q06 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2}, 3));
        System.out.println(solution(new int[]{4, 2, 3, 6, 7, 1, 5, 8}, 16));
        System.out.println(solution(new int[]{4, 2, 3, 6, 7, 1, 5, 8}, 27));
        System.out.println(solution(new int[]{7, 8, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2}, 35));
        System.out.println(solution(new int[]{3, 1, 2}, 100));
    }

    private static int solution(int[] food_times, long k) {

        // 전체 음식을 먹는 시간보다 k가 크거나 같다면 -1
        long summary = 0;
        for (int food_time : food_times) {
            summary += food_time;
        }
        if (summary <= k) return -1;

        // 시간이 작은 음식부터 빼야 하므로 우선순위 큐를 이용
        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            // (음식 시간, 음식 번호) 형태로 우선순위 큐에 삽입
            pq.offer(new Food(food_times[i], i + 1));
        }

        summary = 0; // 먹기 위해 사용한 시간
        long previous = 0; // 직전에 다 먹은 음식 시간
        long length = food_times.length; // 남은 음식의 개수

        // summary + (현재의 음식 시간 - 이전 음식 시간) * 현재 음식 개수와 k 비교
        while (summary + ((pq.peek().getTime() - previous) * length) <= k) {
            int now = pq.poll().getTime();
            summary += (now - previous) * length;
            length -= 1; // 다 먹은 음식 제외
            previous = now; // 이전 음식 시간 재설정
        }

        // 남은 음식 중에서 몇 번째 음식인지 확인하여 출력
        ArrayList<Food> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        // 음식의 번호 기준으로 정렬
        result.sort(Comparator.comparingInt(Food::getIndex));
        return result.get((int) ((k - summary) % length)).getIndex();
    }
}

class Food implements Comparable<Food> {

    private int time;
    private int index;

    public Food(int time, int index) {
        this.time = time;
        this.index = index;
    }

    public int getTime() {
        return this.time;
    }

    public int getIndex() {
        return this.index;
    }

    // 시간이 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Food other) {
        return Integer.compare(this.time, other.time);
    }
}