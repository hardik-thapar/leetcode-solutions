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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode track = dummy;
        int carry = 0;
        int sum = 0;
        while(l1!=null || l2!=null){
            if(l1!=null && l2!=null){
            sum = l1.val + l2.val + carry;
            carry = sum/10;
            sum = sum%10;
            ListNode newNode = new ListNode(sum);
            track.next = newNode;
            track = track.next;
            l1=l1.next;
            l2=l2.next;
            } 
            else if(l2==null){
            sum = l1.val + carry;
            carry = sum/10;
            sum = sum%10;
            ListNode newNode = new ListNode(sum);
            track.next = newNode;
            track = track.next;
            l1=l1.next;
            }
            else{
            sum = l2.val + carry;
            carry = sum/10;
            sum = sum%10;
            ListNode newNode = new ListNode(sum);
            track.next = newNode;
            track = track.next;
            l2=l2.next;
            }
        }
        // while(l1!=null){
        //     ListNode newNode = new ListNode(l1.val+carry);
        // }
        if(carry!=0){
            ListNode newNode = new ListNode(carry);
            track.next = newNode;
            track = track.next;
        }
        return dummy.next;
    }
}