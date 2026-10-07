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
        ArrayList<ListNode> arr = new ArrayList<>();

        ListNode temp = head;
        while(temp!=null){
            arr.add(temp);
            temp = temp.next;
        }

        temp = head;
        ListNode next = temp.next;

        int ind = arr.size()-1;

        while(ind>=(arr.size()+1)/2){
            temp.next = arr.get(ind);
            temp.next.next = next;
            temp = next;
            ind--; 
            next = temp.next;
        }

        temp.next = null;

    }
}