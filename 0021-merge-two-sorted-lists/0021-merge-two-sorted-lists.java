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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode track = dummy;
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                track.next = list1;
                track = track.next;
                list1 = list1.next;
            }
            else{
                track.next = list2;
                track = track.next;
                list2 = list2.next;
            }
        }

        while(list1!=null){
            track.next = list1;
            list1 = list1.next;
            track = track.next;
        }

        while(list2!=null){
            track.next = list2;
            list2 = list2.next;
            track = track.next;
        }

        return dummy.next;
    }
}