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
            if(curr==null) res.append("null,");
            else{
                res.append(curr.val+",");
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    int pre = 0;
    public TreeNode deserialize(String data) {
        if(data=="") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[pre++]));
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(!arr[pre].equals("null")){
                curr.left = new TreeNode(Integer.parseInt(arr[pre]));
                q.add(curr.left);
            }
            pre++;
            if(!arr[pre].equals("null")){
                curr.right=new TreeNode(Integer.parseInt(arr[pre]));
                q.add(curr.right);
            }
            pre++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));