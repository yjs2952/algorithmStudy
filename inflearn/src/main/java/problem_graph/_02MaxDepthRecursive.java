package problem_graph;

public class _02MaxDepthRecursive {
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

        System.out.println(dfs(node));
    }

    private static int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(dfs(node.left), dfs(node.right));
    }

    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x){
            this.val = x;
        }
    }
}
