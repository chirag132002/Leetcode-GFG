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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
        int levelSize = q.size();
        List<Integer> currentLevel = new ArrayList<>(levelSize);
        for(int i = 0; i<levelSize; i++){
            TreeNode currNode = q.poll();
            currentLevel.add(currNode.val);
            if(currNode.left!= null){
                q.offer(currNode.left);
            }
            if(currNode.right!=null){
                q.offer(currNode.right);
            }
        }
        ans.add(0, currentLevel);     
        }
        return ans;
    }
}