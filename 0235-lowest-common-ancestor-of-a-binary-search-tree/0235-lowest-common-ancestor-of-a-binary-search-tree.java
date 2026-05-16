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
    public boolean get_path(TreeNode root, TreeNode target, List<TreeNode> list){
        if(root==null) return false;
        list.add(root);
        if(root==target) return true;
        if(get_path(root.left, target, list) || get_path(root.right, target, list)) return true;
        else list.remove(root);
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> l1 = new ArrayList<>();
        List<TreeNode> l2 = new ArrayList<>();
        get_path(root,p,l1);
        get_path(root,q,l2);
        int n = Math.min(l1.size(),l2.size());
        for(int i=1; i<n; i++){
            if(!l1.get(i).equals(l2.get(i))) return l1.get(i-1);
        }
        return l1.get(n-1);
    }
}