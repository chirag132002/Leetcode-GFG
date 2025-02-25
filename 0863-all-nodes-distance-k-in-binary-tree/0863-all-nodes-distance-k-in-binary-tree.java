/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode, TreeNode> collect;
    Map<TreeNode, Boolean> visited;
    List<Integer> ans;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        collect = new HashMap<>();
        ans = new ArrayList<>();
        visited = new HashMap<>();
        visited.put(target, true);
        collecting(root);
        finder(target,k,0);
        return ans;
    }
    public void collecting(TreeNode root){
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            TreeNode temp = que.poll();
            if(temp.left != null){
                collect.put(temp.left, temp);
                que.add(temp.left);
            }
            if(temp.right != null){
                collect.put(temp.right, temp);
                que.add(temp.right);
            }
        }
    }
    public void finder(TreeNode root, int k, int cnt){
        if(root == null){
            return;
        }
        if(cnt == k){
            ans.add(root.val);
            return;
        }
        if(root.left != null && visited.get(root.left) == null){
            visited.put(root.left, true);
            finder(root.left, k, cnt+1);
        }
        if(root.right != null && visited.get(root.right) == null){
            visited.put(root.right, true);
            finder(root.right, k, cnt+1);
        }
        if(collect.containsKey(root) && visited.get(collect.get(root)) == null){
            visited.put(collect.get(root), true);
            finder(collect.get(root), k, cnt+1);
        }
    }
}