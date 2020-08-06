//package toss;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class P3 {
//    public static void main(String[] args) throws Exception {
//        // [!!주의!!] Function.compute 함수는 이미 구현되어있지만, 숨김처리되어 있습니다. 호출해서 테스트 해주세요.
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();
//        System.out.println("Hello Goorm! Your input is " + solution(input));
//    }
//
//    public static String solution(String input){
//
//        String[] split = input.split(" ");
//
//        StringBuilder sb = new StringBuilder();
//
//        List<Integer> numbers = Arrays.stream(split)
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//
//        List<String> list = numbers.parallelStream().map(num -> Function.compute(num))
//                .collect(Collectors.toList());
//
//        sb.deleteCharAt(sb.length() - 1);
//
//        return sb.toString();
//    }
//}
