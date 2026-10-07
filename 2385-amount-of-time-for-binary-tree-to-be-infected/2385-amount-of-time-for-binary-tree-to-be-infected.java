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
    class Pair {
        TreeNode node;
        int dist;
        Pair(TreeNode node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public int amountOfTime(TreeNode root, int start) {
        // parent pointer building
        //child -> parent mapping
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        TreeNode st = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.val==start) st = curr;
            if(curr.left!=null){
                parent.put(curr.left, curr);
                q.offer(curr.left);
            }
            if(curr.right!=null){
                parent.put(curr.right, curr);
                q.offer(curr.right);
            }
        }

        // now we start from st node, and from their the neighbours are left, right, parent(from map)
        Set<TreeNode> visited = new HashSet<>();
        int res = 0;
        Queue<Pair> q2 = new LinkedList<>();
        q2.offer(new Pair(st, 0));
        visited.add(st);
        while(!q2.isEmpty()){
            Pair curr = q2.poll();
            //left 
            if(curr.node.left!=null && !visited.contains(curr.node.left)){
                q2.offer(new Pair(curr.node.left, curr.dist+1));
                visited.add(curr.node.left);
            }
            // right
            if(curr.node.right!=null && !visited.contains(curr.node.right)){
                q2.offer(new Pair(curr.node.right, curr.dist+1));
                visited.add(curr.node.right);
            }
            //parent
            if(parent.get(curr.node)!=null && !visited.contains(parent.get(curr.node))){
                q2.offer(new Pair(parent.get(curr.node), curr.dist+1));
                visited.add(parent.get(curr.node));
            }
            res = Math.max(res, curr.dist);
        }
        return res;
    }
}