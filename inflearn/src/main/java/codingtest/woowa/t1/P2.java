package codingtest.woowa.t1;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class P2 {

    private static final Map<String, List<String>> TYPES = new LinkedHashMap<>();

    static {
        TYPES.put("music", Arrays.asList("mp3", "aac", "flac"));
        TYPES.put("images", Arrays.asList("jpg", "bmp", "gif"));
        TYPES.put("movies", Arrays.asList("mp4", "avi", "mkv"));
        TYPES.put("other", Collections.emptyList());
    }

    public static void main(String[] args) {
        String input =
                "my.song.mp3 11b\n" +           // music
                "greatSong.flac 1000b\n" +      // music
                "not3.txt 5b\n" +               // other
                "video.mp4 200b\n" +            // other
                "game.exe 100b\n" +             // other
                "mov!e.mkv 10000b";             // movie

        System.out.println(solution(input));
    }

    private static String solution(String S) {
        return resultMessage(groupByType(groupByExtension(S)));
    }

    private static Map<String, Integer> groupByExtension(String S) {
        return Arrays.stream(S.split("\n"))
                .map(s -> s.substring(s.lastIndexOf(".") + 1, s.length() - 1))
                .map(s -> s.split(" "))
                .collect(groupingBy(array -> array[0], summingInt(array -> Integer.parseInt(array[1]))));
    }

    private static String resultMessage(Map<String, Integer> result) {
        StringBuilder sb = new StringBuilder();
        for (String type : TYPES.keySet()) {
            sb
                .append(type)
                .append(" ")
                .append(result.getOrDefault(type, 0))
                .append("b")
                .append("\n");
        }
        return sb.toString();
    }

    private static Map<String, Integer> groupByType(Map<String, Integer> groupByExtension) {
        Map<String, Integer> result = new HashMap<>();
        for (String extension : groupByExtension.keySet()) {
            String type = findTypeByExtension(extension);
            result.put(type, result.getOrDefault(type, 0) + groupByExtension.getOrDefault(extension, 0));
        }
        return result;
    }

    private static String findTypeByExtension(String extension) {
        return TYPES.entrySet().stream()
                .filter(entry -> entry.getValue().contains(extension))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("other");
    }
}
