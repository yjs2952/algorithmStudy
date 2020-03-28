package problem_graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _04WordLadder {

    /**
     * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
     * Only one letter can be changed at a time.
     * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
     * Note:
     * Return 0 if there is no such transformation sequence.
     * All words have the same length.
     * All words contain only lowercase alphabetic characters.
     * You may assume no duplicates in the word list.
     * You may assume beginWord and endWord are non-empty and are not the same.
     * Example 1:
     * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
     * Output: 5
     * Explanation: As one shortest transformation is
     * "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
     */
    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dog", "lot", "dot", "cog", "log");

        System.out.println(ladder(beginWord, endWord, wordList));
    }

    public static int ladder(String beginWord, String endWord, List<String> wordList){
        if (beginWord.length() <= 0 || endWord.length() <= 0 || beginWord.length() != endWord.length() || beginWord.equals(endWord))
            return 0;

        int result = 1;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                String str = queue.poll();

                char[] chars = str.toCharArray();

                if (str.equals(endWord)) {
                    return result;
                }

                for (String word : wordList) {
                    int diffCnt = 0;
                    for (int j = 0; j < word.length(); j++) {
                        if (chars[j] != word.charAt(j)) {
                            diffCnt++;
                        }
                    }

                    if (diffCnt == 1) {
                        queue.offer(word);
                    }
                }
            }
            result++;
        }

        return 0;
    }
}
