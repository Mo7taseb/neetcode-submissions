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
        if(head.next == null) return null;
        int count = 0;
        ListNode dummy = head;
        while (head != null) {
            count++;
            head = head.next;
        }
        if(n==count) return dummy.next;
        head = dummy;
        count = count - n;
        ListNode prev = null;
        while (head != null) {
            if (count == 1) {
                head.next = head.next.next;
            }
            count--;
            head = head.next;
        }

        return dummy;
    }
}
