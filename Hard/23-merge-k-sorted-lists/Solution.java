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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        if(lists.length==1){
            return lists[0];
        }

        ListNode newHead = null;
        for(int i=1; i<lists.length; i++){
            if(newHead==null){
                newHead = mergeTwoLists(lists[0],lists[i]);
            }else{
                newHead = mergeTwoLists(newHead,lists[i]);
            }
        }

        return newHead;
        
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                temp.next = l1;
                l1= l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if(l1!=null){
            temp.next = l1;
        }
        if(l2!=null){
            temp.next = l2;
        }

        return head.next;
    }
}