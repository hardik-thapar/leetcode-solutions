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
    public int height(TreeNode root){
        if(root==null) return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
    public boolean hb(TreeNode root){
       if(root==null) return true;
       boolean l = hb(root.left);
       boolean r = hb(root.right);
       int hl = height(root.left);
       int hr = height(root.right);
       if(l && r && Math.abs(hl-hr)<=1) return true;
       return false;

    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return hb(root);
    }
}