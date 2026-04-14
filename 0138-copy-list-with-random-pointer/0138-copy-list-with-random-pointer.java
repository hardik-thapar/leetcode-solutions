/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        Node curr = head;
        Node newHead = new Node(0);
        Node track = newHead;
        while(curr!=null){
            Node N = new Node(curr.val);
            map.put(curr,N);
            track.next = N;
            track = track.next;
            curr = curr.next;
        }

        Node c = head;
        while(c!=null){
             Node cur = map.get(c);
             cur.random = map.get(c.random);
             c=c.next;

        }
        return newHead.next;
    }
}