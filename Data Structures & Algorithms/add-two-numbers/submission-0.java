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
        ListNode head = new ListNode();
        ListNode dummy = head;
        int sum = 0;
        ListNode prev = new ListNode();
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                sum += l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                sum += l1.val;
                l1 = l1.next;
            } else {
                sum += l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }

            head.val = sum % 10;
            sum /= 10;
            head.next = new ListNode();
            prev = head;
            head = head.next;
        }
        if (sum != 0) {
            head.val = sum;
        } else if (sum == 0) {
            prev.next= null;
        }

        return dummy;
    }
}
