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
    List<int[]> nodes = new ArrayList<>();
    private void dfs(TreeNode root, int row, int col) {
        if (root==null) return;

        nodes.add(new int[]{col, row, root.val});

        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        // custom comparator 
        Collections.sort(nodes, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        List<List<Integer>> ans = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;

        for (int[] node: nodes) {
            int col = node[0];

            if (col!=prevCol) {
                ans.add(new ArrayList<>());
                prevCol = col;
            }

            ans.get(ans.size() - 1).add(node[2]);
        }

        return ans;
    }

    
}