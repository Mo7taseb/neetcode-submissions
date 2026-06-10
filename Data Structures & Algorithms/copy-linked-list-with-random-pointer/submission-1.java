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
        if (head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();
        Node current = head;

        // 1. First loop: Build the clones and store them
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        // 2. Wire them up using ONLY the Map entries, ignoring original node fields
        for (Map.Entry<Node, Node> entry : map.entrySet()) {
            Node originalNode = entry.getKey();
            Node clonedNode = entry.getValue();

            // We look up the destinations in the map using the original nodes as keys
            clonedNode.next = map.get(originalNode.next);
            clonedNode.random = map.get(originalNode.random);
        }

        return map.get(head);
    }
}

