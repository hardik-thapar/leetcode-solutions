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
    int count = 0;
    public void check(TreeNode root, int max){
        if(root==null) return;
        if(root.val >= max){
            count++;
            max = root.val;
        }
        check(root.left, max);
        check(root.right, max);
        return;
    }
    public int goodNodes(TreeNode root) {
        check(root, Integer.MIN_VALUE);
        return count;
    }
}