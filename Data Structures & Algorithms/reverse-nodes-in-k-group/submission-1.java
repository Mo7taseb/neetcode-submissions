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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroup = dummy;
        while (head != null) {
            ListNode groupStart = head;
            int count = 1;
            while (head != null && count < k) {
                head = head.next;
                count++;
            }
            if (head == null)
                break;
            ListNode nextGroup = head.next;
            head.next = null;
            prevGroup.next = reverse(groupStart);
            groupStart.next = nextGroup;
            prevGroup = groupStart;
            head = nextGroup;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }
}
