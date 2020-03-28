package problem_graph;

import java.util.LinkedList;
import java.util.Queue;

public class _02MaxDepthBFS {
    /**
     * Given a binary tree, find its maximum depth.
     * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     * Note: A leaf is a node with no children.
     * Example:
     * Given binary tree [3,9,20,null,null,15,7],
     *   3
     *  / \
     * 9 20
     *   / \
     *  15 7
     * return its depth = 3.
     */

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.left.left = new TreeNode(5);
        node.left.left.right = new TreeNode(9);
        node.left.left.right.right = new TreeNode(10);
        node.left.right = new TreeNode(8);
        node.left.left.left = new TreeNode(7);

        System.out.println(solve(node));
    }

    private static int solve(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result++;
        }


        return result;
    }

    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x){
            this.val = x;
        }
    }
}
