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
    int count=0;
    int min = 0;
    public void bst(TreeNode root, int k){
        if(root==null) return;
        bst(root.left, k);
        if(count>=k) return;
        count++;
        min = root.val;
        bst(root.right, k);
        return;
    }
    public int kthSmallest(TreeNode root, int k) {
        bst(root, k);
        return min;
    }
}