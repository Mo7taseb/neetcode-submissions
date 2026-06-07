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
        if (head == null || head.next == null) return ;

        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        second = reverseNode(second);

        ListNode first = head;
        

        while (first!= null && second != null) {
            ListNode t1 = first.next, t2 = second.next;
            first.next = second;
            second.next = t1;

            first = t1;
            second = t2;
            
        }

    }

    public ListNode reverseNode (ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        while(head != null) {
        ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        } 
        return prev;
    }
}