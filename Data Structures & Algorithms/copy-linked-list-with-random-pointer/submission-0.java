/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node dummy = head;
        while (head != null) {
            map.put(head, new Node(head.val));
            head = head.next;
        }

        head = dummy;
        while(head!= null){
            map.get(head).next = map.get(head.next);
            map.get(head).random = map.get(head.random);
            head= head.next;
        }
        return map.get(dummy);
    }
}
