package codingtest.woowa.t2;

import java.util.LinkedList;
import java.util.Queue;

public class P1 {
    public static void main(String[] args) {
        System.out.println(solution("ABCDEF"));
        System.out.println(solution("ABCDEFGHIJKLMNOP"));
        System.out.println(solution("A"));
    }

    static class Node {
        String value;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private static Node makeTree(char[] arr) {

        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(String.valueOf(arr[0]));
        queue.offer(node);

        int index = 1;
        while (!queue.isEmpty() && index < arr.length) {
            Node temp = queue.poll();

            if (temp != null && temp.left == null) {
                temp.left = new Node(String.valueOf(arr[index++]));
                queue.offer(temp.left);
            }

            if (temp != null && temp.right == null && index < arr.length) {
                temp.right = new Node(String.valueOf(arr[index++]));
                queue.offer(temp.right);
            }
        }

        return node;
    }

    private static String printResult(Node node) {
        String result = "";
        if (node != null) {
            if (node.left != null) {
                result += printResult(node.left);
            }
            if (node.right != null) {
                result += printResult(node.right);
            }
            result += node.value;
        }
        return result;
    }

    private static String solution(String message) {
        char[] charArray = message.toCharArray();
        Node root = makeTree(charArray);
        return printResult(root);
    }

}


