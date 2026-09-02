/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private List<Integer> res = new ArrayList<>();
    private void dfs(Node root){
        if(root==null) return;
        res.add(root.val);
        for(Node ch: root.children){
            dfs(ch);
        }
        return;
    }
    public List<Integer> preorder(Node root) {
       dfs(root);
       return res;
    }
}