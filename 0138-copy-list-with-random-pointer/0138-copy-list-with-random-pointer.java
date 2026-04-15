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
        Node dummy = new Node(0);
        Node track = dummy;
        Node curr = head;

        HashMap<Node, Node> map = new HashMap<>();

        while(curr!=null){
            Node newNode = new Node(curr.val);
            track.next = newNode;
            map.put(curr,newNode);
            track = track.next;
            curr = curr.next;
        }

        curr = head;
        track = dummy.next;
        while(curr!=null){
            track.random = map.get(curr.random);
            curr = curr.next;
            track = track.next;
        }
        return dummy.next;
    }
}