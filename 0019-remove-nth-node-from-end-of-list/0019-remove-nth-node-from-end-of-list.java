/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return head;
        if(head.next == null) return null;
        // if(n==1){
        //     head=head.next;
        // }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        curr.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;
        int i = 0;
        while(i<n && fast.next!=null){
            fast = fast.next;
            i++;
        }

        while(fast.next!=null){
            fast=fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
        
    }
}