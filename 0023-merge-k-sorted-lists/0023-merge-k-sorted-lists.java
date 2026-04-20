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
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode curr = new ListNode(0);
        ListNode temp = curr;
        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            }
            else{
                temp.next = l2;
                l2=l2.next;
                temp=temp.next;
            }
        }

        while(l1!=null){
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }

        while(l2!=null){
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }

        return curr.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int v = Integer.MIN_VALUE;
        int n = lists.length;
        if(n==0) return null;
        ListNode curr = lists[0];
        // ListNode curr = test;
        for(int i=1;i<n;i++){
            ListNode temp = lists[i];
            curr = merge(curr,temp);
        }
        return curr;
    }
}