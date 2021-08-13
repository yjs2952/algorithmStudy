package codingtest.six;

import java.util.*;

public class P2 {

    public static void main(String[] args) {
        String[] a1 = {"alex111 100", "cheries2 200", "coco 150", "luna 100", "alex111 120", "coco 300", "cheries2 110"};
        String[] a2 = {"alex111 100", "cheries2 200", "alex111 200", "cheries2 150", "coco 50", "coco 200"};
        String[] a3 = {"cheries2 200", "alex111 100", "coco 150", "puyo 120"};

        System.out.println(solution1(3, a1));
        System.out.println(solution1(3, a2));
        System.out.println(solution1(2, a3));
    }

    private static int solution(int k, String[] user_scores) {
        Map<String, Integer> userScoreMap = new HashMap<>();


        for (String userScore : user_scores) {
            String[] splits = userScore.split(" ");
            String name = splits[0];
            int score = Integer.parseInt(splits[1]);


        }
        return 0;
    }

    private static int solution1(int K, String[] user_scores) {
        int answer = 0;
        //
        List<Rank> list = new ArrayList<>();
        List<String> page = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        int next = 0;
        for (String user_score : user_scores) { // 일단 1페이지를 먼저 채운다.
            next++;
            if (list.size() >= K) break;
            StringTokenizer tokens = new StringTokenizer(user_score);
            String nickName = tokens.nextToken();
            int score = Integer.parseInt(tokens.nextToken());
            if (!temp.contains(nickName)) {
                list.add(new Rank(nickName, score));
                answer++;
                temp.add(nickName);
            } else {
                for (Rank rank : list) {
                    if (rank.nickName.equals(nickName) && rank.score < score) {
                        rank.score = score;
                        break;
                    }
                }
            }
        }
        Collections.sort(list); // 점수순으로 정렬
        for (Rank value : list) { // 1페이지 랭킹 저장
            page.add(value.nickName);
        }

        for (int i = next; i < user_scores.length; i++) { // 남은애들 랭크 먹이기
            temp.clear();
            StringTokenizer tokens = new StringTokenizer(user_scores[i]);
            String nickName = tokens.nextToken();
            int score = Integer.parseInt(tokens.nextToken());
            list.add(new Rank(nickName, score)); // 걍 무지성으로 더함
            Collections.sort(list); // 점수순으로 정렬
            list.remove(list.size() - 1); // 마지막 인덱스 없애기.
            for (Rank rank : list) { // temp 에 최신 랭크 저장
                temp.add(rank.nickName);
            }
            for (int j = 0; j < temp.size(); j++) { // 최신 랭크 temp와 기존 랭킹 page가 다르면 갱신되는거임
                if (!temp.get(j).equals(page.get(j))) {
                    page.clear();
                    page.addAll(temp);
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    static class Rank implements Comparable<Rank> {
        String nickName;
        int score;

        public Rank(String nickName, int score) {
            super();
            this.nickName = nickName;
            this.score = score;
        }

        @Override
        public int compareTo(Rank o) {
            return Integer.compare(o.score, this.score);
        }

        @Override
        public String toString() {
            return "Rank [nickName=" + nickName + ", score=" + score + "]";
        }

    }

}
