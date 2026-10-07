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
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l2 = reverseNode(slow);
        mergeList(head, l2);

    }

    public void mergeList(ListNode l1, ListNode l2){
        ListNode t1 = l1;
        ListNode t2 = l2;

        ListNode newHead = new ListNode(1);
        ListNode temp = newHead;
        boolean flag = true;

        while(t1!=null && t2!=null){
            if(flag){
                temp.next = t1;
                t1= t1.next;
                temp = temp.next;
                flag = false;
            }else{
                temp.next = t2;
                t2 = t2.next;
                temp = temp.next;
                flag = true;
            }
        }
    }

    public ListNode reverseNode(ListNode node){
        ListNode prev = null;
        ListNode curr = null;
        ListNode next = node;

        while(next!=null){
            curr = next;
            next = next.next;
            curr.next = prev;
            prev = curr;
        }

        return curr;

    }
}