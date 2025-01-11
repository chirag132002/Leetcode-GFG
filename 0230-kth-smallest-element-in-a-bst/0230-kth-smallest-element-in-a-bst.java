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
    
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root,  k, list);
        return list.get(k-1);
    }
    private void inOrder(TreeNode root, int k, List<Integer> list){
        if(root==null){
            return;
        }
        if(root.left!=null){
            inOrder(root.left, k, list);
        }
        list.add(root.val);
        if(list.size()>=k){ // we onlyneed k element in our list
            return;
        }
        if(root.right!=null){
            inOrder(root.right, k, list);
        }
}
}