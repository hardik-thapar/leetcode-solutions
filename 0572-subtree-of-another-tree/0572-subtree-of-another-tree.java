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
    public int check(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot==null) return 1;
        if(root==null) return 0;
        if(subRoot==null && root!=null) return 0;
        if(root==null && subRoot!=null) return 0;
        if(root.val!=subRoot.val) return 0;
        // if(check(root.left, subRoot.left) && check(root.right, subRoot.right)) return true;
        int l = check(root.left, subRoot.left);
        int r = check(root.right, subRoot.right);
        if(l==1 && r==1) return 1;
        // int left = check(root.left, subRoot);
        // int right = check(root.right,subRoot);
        // // return (check(root.left, subRoot)==1 || check(root.right,subRoot)==1);
        // if(left==1 || right==1) return 1;
        return 0;


    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null) return true;
        if(root==null && subRoot!=null) return false;
        if(root!=null && subRoot==null) return true; 
        if(root==null) return false;
        if(check(root,subRoot)==1) return true;
        return(isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }
}