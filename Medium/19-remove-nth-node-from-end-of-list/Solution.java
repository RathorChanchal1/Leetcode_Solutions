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

        int len = 1;

        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            len++;
            fast = fast.next.next;
            slow = slow.next;
            if(fast==null){
                len = len*2-2;
            }else if(fast.next==null){
                len = len*2-1;
            }
        }

        if(len == n){
            return head.next;
        }

        n = len-n;
        len = 1;
        slow = head;

        while(len<n){
            slow = slow.next;
            System.out.println(slow.val);
            len++;
        }

            if(slow.next!=null){
                slow.next = slow.next.next;
            }

        return head;

    }
}