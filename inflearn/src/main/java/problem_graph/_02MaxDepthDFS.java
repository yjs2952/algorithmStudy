package problem_graph;

import java.util.Stack;

public class _02MaxDepthDFS {
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

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();
        int max = 0;

        if (root == null) return 0;

        stack.push(root);
        valueStack.push(1);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            int depth = valueStack.pop();

            if (node.left != null) {
                stack.push(node.left);
                valueStack.push(depth + 1);
            }

            if (node.right != null) {
                stack.push(node.right);
                valueStack.push(depth + 1);
            }

            max = Math.max(max, depth);
//            max = depth;
        }
        return max;
    }

    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x){
            this.val = x;
        }
    }
}
