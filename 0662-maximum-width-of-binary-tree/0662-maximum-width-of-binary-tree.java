/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelStart = queue.peek().getValue();
            int levelEnd = 0;

            for (int i = 0; i < levelSize; i++) {
                Pair<TreeNode, Integer> entry = queue.poll();
                TreeNode node = entry.getKey();
                int position = entry.getValue();
                levelEnd = position;

                if (node.left != null) queue.offer(new Pair<>(node.left, position * 2));
                if (node.right != null) queue.offer(new Pair<>(node.right, position * 2 + 1));
            }

            maxWidth = Math.max(maxWidth, levelEnd - levelStart + 1);
        }

        return maxWidth;
    }
}