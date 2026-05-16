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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr==null){
                res.add(temp);
                temp = new ArrayList<>();
                if(q.isEmpty()) return res;
                q.add(null);
            }
            else{
            temp.add(curr.val);
            if(curr.left!=null) q.add(curr.left);
            if(curr.right!=null) q.add(curr.right);
            }
        }
        return res;
    }
}