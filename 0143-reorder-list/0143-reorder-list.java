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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow=slow.next;
        }
        // head of second list is at slow
        // we have to reverse it
        ListNode prev = null;
        ListNode curr = slow.next;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        slow.next = null;
        // new reversed head at prev
        // we have two lists, first list head is at head and secodn list head at prev;
        ListNode first = head;
        ListNode second = prev;
        int count = 0;
        ListNode newHead = new ListNode(0);
        ListNode track = newHead;

        while(first!=null && second!=null){
            if(count%2==0){
                track.next = first;
                first = first.next;
            }
            else{
                track.next = second;
                second = second.next;
            }
            track = track.next;
            count++;
        }

        while(first!=null){
            track.next = first;
            first=first.next;
            track = track.next;
        }

        while(second!=null){
            track.next = second;
            second = second.next;
            track = track.next;
        }

        head = newHead.next;

    }
}