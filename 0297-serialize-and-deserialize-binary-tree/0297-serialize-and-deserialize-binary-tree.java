/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuffer res = new StringBuffer();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr==null) res.append("null"+",");
            else{
                res.append(curr.val+",");
                q.add(curr.left);
                q.add(curr.right);
            }

        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="") return null;
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        int pre = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(!nodes[pre+1].equals("null")) {curr.left = new TreeNode(Integer.parseInt(nodes[pre+1]));
            q.add(curr.left); }
            pre++;
            if(!nodes[pre+1].equals("null")) {curr.right = new TreeNode(Integer.parseInt(nodes[pre+1]));
            q.add(curr.right); }
            pre++;
        }
        return root;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));